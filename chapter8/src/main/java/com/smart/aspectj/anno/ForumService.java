package com.smart.aspectj.anno;

public class ForumService {
    @NeedTest(value = true)
    public void deleteForum(int forumId){
        System.out.println("删除："+forumId);
    }

    @NeedTest(value = false)
    public void deletepost(int postId){
        System.out.println("删除："+postId);
    }


}
