package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class TopicDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public double getReplyRate(int UserId){
        String sql = "SELECT topic_replies topic_views FROM t_topic WHERE user_id = ?";
        double rate = jdbcTemplate.queryForObject(sql, new Object[]{UserId}, new RowMapper<Double>() {
            public Double mapRow(ResultSet resultSet, int i) throws SQLException {
                int replies = resultSet.getInt("topic_replies");
                int views = resultSet.getInt("topic_views");
                return new Double((double) replies / views);
            }});
        return rate;
    }

    public void getUserTopicName(final int userId){
        String sql = "call P_GET_TOPIC_NUM(?,?)";
        Integer number = jdbcTemplate.execute(sql, new CallableStatementCallback<Integer>() {
            public Integer doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                callableStatement.setInt(1,userId);
                callableStatement.registerOutParameter(2, Types.INTEGER);
                callableStatement.execute();
                return callableStatement.getInt(2);
            }
        });

    }
}
