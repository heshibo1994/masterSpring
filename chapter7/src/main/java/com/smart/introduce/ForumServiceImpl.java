package com.smart.introduce;


public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        System.out.println("删除topic记录： "+topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void removeForum(int forumId) {
        System.out.println("删除topic记录： "+forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
