package com.smart.dao;

import com.smart.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {
    private static final String GET_PAGED_POSTS = "from Post where topic.topicId = ? " +
            "order by createTime desc";
    private static final String DELETE_TOPIC_POSTS = "delete from Post where topic.topicId = ？";

    public Page getPagesPosts(int topicId,int pageNo,int pageSize){
        return pagedQuery(GET_PAGED_POSTS,pageNo,pageSize,topicId);
    }

    public void deteleTopicPost (int topicId){
        getHibernateTemplate().delete(DELETE_TOPIC_POSTS,topicId);
    }

}
