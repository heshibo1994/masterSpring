package com.smart.dao;

import com.smart.domain.Topic;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDao extends BaseDao<Topic>{
    private static final String GET_BOARD_DIGEST_TOPIC = "from Topic t where t.board = ? " +
            "and diget > 0 order by t.lastPost desc,digest desc";
    private static final String GET_PAGED_TOPICS = "from Topic  where boardId = ? " +
            "order by t.lastPost desc";
    private static final String QUERY_TOPIC_BY_TITLE = "from Topic where topicTitle like ?" +
            "order by lastPost desc";

    // 获取论坛板块某一页的精华主题帖子，按照回复时间排序
    public Page getBoardDigestTopic(int boardId,int pageNo,int pageSize){
        return pagedQuery(GET_BOARD_DIGEST_TOPIC,pageNo,pageSize,boardId);
    }

    // 获取论坛板块某一页的主题帖子，按照回复时间排序
    public Page getPagedTopics(int boardId,int pageNo,int pageSize){
        return pagedQuery(GET_PAGED_TOPICS,pageNo,pageSize,boardId);
    }
    // 获取和主题帖子标题模糊匹配的主题帖子
    public Page queryTopicByTitle(String title, int pageNo, int pageSize){
        return pagedQuery(QUERY_TOPIC_BY_TITLE,pageNo,pageSize,title);
    }

}
