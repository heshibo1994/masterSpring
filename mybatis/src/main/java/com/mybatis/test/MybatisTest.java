package com.mybatis.test;

import com.mybatis.datasource.DataConnection;
import com.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MybatisTest {
    public DataConnection dataConnection = new DataConnection();

    @Test
    public void selectTest() throws IOException, ParseException, ParseException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // 查询
        User user1 = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user1.getUsername());
        List<User> user = sqlSession.selectList("test.findUserByUsername","男");
        for(User u : user){
            System.out.println(u);
        }

        // 新增
        User user2 = new User(1,"麻子","5555","女","55555@163.com",
                "湖北","武汉",new SimpleDateFormat("yyyy-MM-dd").parse("2005-5-5"));
//        sqlSession.insert("test.insertUser",user2);

        // 删除
        sqlSession.delete("test.deleteUser",7);

        // 更新
        user2.setUsername("新的麻子");
        sqlSession.update("test.updateUsername",user2);

        // reslutMap

        User use3 = sqlSession.selectOne("findUserByResultMap",1);
        System.out.println("resultMap:"+use3);
        sqlSession.commit();
        sqlSession.close();
    }

}
