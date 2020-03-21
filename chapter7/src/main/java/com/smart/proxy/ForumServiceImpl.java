package com.smart.proxy;



public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        PerformanceMonitor.begin("com.smart.ForumServiceImpl.removeTopic()");
        System.out.println("删除topic记录： "+topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }


    @Override
    public void removeForum(int forumId) {
        PerformanceMonitor.begin("com.smart.ForumServiceImpl.removeForum()");
        System.out.println("删除topic记录： "+forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();

    }
}
