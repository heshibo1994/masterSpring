package com.smart.dao;

import com.smart.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForumDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initDb(){
        String sql = "create table t_user(user_id int primary key,user_name varchar(60))";
        jdbcTemplate.execute(sql);
    }

    //更新数据
    public void addForum(final Forum forum){
        final String sql = "insert into t_forum(forum_name,forum_desc) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,forum.getForumName());
                ps.setString(2,forum.getForumDesc());
                return ps;
            }
        },keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());

//        Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc()};
//        jdbcTemplate.update(sql,params);

    }


    //查询数据
    public Forum getForum(final int forumId){
        String sql = "select forum_name,forum_desc from t_forum where forum_id = ?";
        final Forum forum = new Forum();
        jdbcTemplate.query(sql, new Object[]{forumId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                forum.setForumId(forumId);
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
            }
        });
        return forum;
    }

    //查询多条数据
    public List<Forum> getForum(final int fromId, final int toId){
        String sql = "select forum_id forum_name,forum_desc from t_forum where " +
                "forum_id between ? and ?";
        final List<Forum> forums = new ArrayList<Forum>();
        jdbcTemplate.query(sql, new Object[]{fromId, toId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                Forum forum = new Forum();
                forum.setForumId(resultSet.getInt("forum_id"));
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
                forums.add(forum);
            }
        });
        return forums;
    }
}
