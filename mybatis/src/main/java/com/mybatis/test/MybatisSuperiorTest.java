package com.mybatis.test;

import com.mybatis.datasource.DataConnection;
import com.mybatis.po.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;


public class MybatisSuperiorTest {
    public DataConnection dataConnection = new DataConnection();

    @Test
    public void testFindOrderUser() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        List<OrderCustom> orderCustom = sqlSession.selectList("test.findOrderUser");
        if(orderCustom!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int i=0;i<orderCustom.size();i++){
                OrderCustom record = orderCustom.get(i);
                System.out.println(i+" 用户:"+record.getUsername()+
                        " 性别："+record.getSex()+" 地址："+record.getAddr()+
                        " 在"+sdf.format(record.getCreatetime())+"买了"+record.getNumber()+"台电脑");
            }
        }
        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserResultMap()throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        List<Orders> orders = sqlSession.selectList("findOrdersAndOrderDetailResultMap");
        if(orders!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int i=0;i<orders.size();i++){
                Orders record = orders.get(i);
                User user = record.getUser();
                System.out.println(i+" 用户:"+user.getUsername()+
                        " 性别："+user.getSex()+" 地址："+user.getAddr()+
                        " 在"+sdf.format(record.getCreatetime())+"买了"+record.getNumber()+"台电脑，其中");
                List<OrderDetails> orderDetails = record.getOrderDetails();
                for(int j = 0;j<orderDetails.size();j++){
                    System.out.println("id为："+orderDetails.get(j).getItemsId()
                            +"的"+"电脑"+orderDetails.get(j).getItemsNum()+"台");
                }
            }
        }
        sqlSession.close();
    }

    @Test
    public void testFindUsersAndItemsResultMap()throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        List<User> users = sqlSession.selectList("findUsersAndItemsResultMap");
        if(users!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(User user:users){
                System.out.println("用户："+user.getUsername()+"ID:"+user.getUserId());
                for(Orders order:user.getOrders()){
                    System.out.println("在"+order.getCreatetime()+"购买了"+order.getNumber()+"台电脑，其中");
                    for(OrderDetails orderDetail:order.getOrderDetails()){
                        System.out.println("id为： "+orderDetail.getItemsId()+"的电脑有"+orderDetail.getItemsNum()+"台,具体情况为");
                        System.out.println(orderDetail.getItems());
                    }
                }

            }
        }
        sqlSession.close();
    }
}
