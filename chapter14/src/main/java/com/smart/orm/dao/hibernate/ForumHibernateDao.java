package com.smart.orm.dao.hibernate;

import java.util.List;

public class ForumHibernateDao extends BaseDao {
    public void addForum(Forum forum){
        getHibernateTemplate().save(forum);
    }

    public void updateForum(Forum forum){
        getHibernateTemplate().update(forum);
    }

    public Forum getForum(int forumId){
        return getHibernateTemplate().get(Forum.class,forumId);
    }

    public List<Forum> findForumByNames(String forumName){
        return (List<Forum>) getHibernateTemplate().find("from Forum f where f.forumName like ?",forumName+"%");
    }

    public long getForumNum(){
        Object obj = getHibernateTemplate().iterate("select count(f.forumId) from Forum f");
        return (long)obj;
    }

}
