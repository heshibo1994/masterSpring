package com.smart.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BaseDao<T> {
    private Class<T> entityClass;

    private HibernateTemplate hibernateTemplate;
    @Autowired
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public BaseDao(){
        Type genType = getClass().getGenericSuperclass();
        Type[] parmas = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class)parmas[0];
    }

    // 根据Id加载PO实例
    public T load(Serializable id){
        return (T)getHibernateTemplate().load(entityClass,id);
    }

    // 根据Id获取PO实例
    public T get(Serializable id){
        return (T)getHibernateTemplate().get(entityClass,id);
    }

    // 获取PO的所有对象
    public List<T> loadall(){
        return (List<T>)getHibernateTemplate().loadAll(entityClass);
    }

    // 保存PO
    public void save(T entity){
        getHibernateTemplate().save(entity);
    }

    // 删除PO
    public void remove(T entity){
        getHibernateTemplate().delete(entity);
    }

    // 更改PO
    public void update(T entity){
        getHibernateTemplate().update(entity);
    }

    // 执行HQL查询
    public  List find(String hql){
        return this.getHibernateTemplate().find(hql);
    }

    public List find(String hql,Object... params){
        return this.getHibernateTemplate().find(hql,params);
    }

    // 对延迟加载的实体类进行初始化
    public void initialize(Object entity){
        this.getHibernateTemplate().initialize(entity);
    }

    // 分页查询函数
    public Page pagedQuery(String hql,int pageNo,int pageSize, Object... values){
        Assert.hasText(hql);
        Assert.isTrue(pageNo>=1,"页码必须从第一页开始");
        String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
        List countList = getHibernateTemplate().find(countQueryString,values);
        long totalCount = (Long) countList.get(0);
        if(totalCount<1){
            return new Page();
        }else{
            int startIndex = Page.getStartOfPage(pageNo,pageSize);
            Query query = createQuery(hql,values);
            List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
            return new Page(startIndex,totalCount,pageSize,list);
        }


    }

    // 去除HQL语句的select部分
    public static String removeSelect(String hql){
        Assert.hasText(hql);
        int beginPos = hql.toLowerCase().indexOf("from");
        Assert.isTrue(beginPos!=-1,"hql语句中不存在from");
        return hql.substring(beginPos);
    }

    // 除HQL语句的orderBy部分
    public static String removeOrders(String hql){
        Assert.hasText(hql);
        Pattern pattern = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(hql);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(stringBuffer,"");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    // 创建Query对象
    public Query createQuery(String hql,Object... values){
        Assert.hasText(hql);
        Query query = getSession().createQuery(hql);
        for(int i=0;i<values.length;i++){
            query.setParameter(i,values[i]);
        }
        return query;
    }

    public Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
