package com.smart.concept;

public class ForumService {
    private TransactionManage transactionManage;
    private PerformanceMonitor pMonitor;
    private TopicDao topicDao;
    private ForumDao forumDao;

    public void removeTopic(int topicId){
        pMonitor.start();
        transactionManage.beginTranscation();
        topicDao.remove(topicId);
        transactionManage.commit();
        pMonitor.end();
    }

    public void createForum(Forum forum){
        pMonitor.start();
        transactionManage.beginTranscation();
        forumDao.remove(forum);
        transactionManage.commit();
        pMonitor.end();

    }
}
