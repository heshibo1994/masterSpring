package com.smart.service;

import com.smart.dao.*;
import com.smart.domain.*;
import com.smart.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ForumService {
    private TopicDao topicDao;
    private UserDao userDao;
    private BoardDao boardDao;
    private PostDao postDao;

    public TopicDao getTopicDao() {
        return topicDao;
    }
    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public BoardDao getBoardDao() {
        return boardDao;
    }
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }
    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    // 发表一个主题帖子
    public void addTopic(Topic topic){
        // 论坛帖子数+1
        Board board = (Board)boardDao.get(topic.getBoardId());
        board.setTopicNum(board.getTopicNum()+1);
        topicDao.save(topic);

        topic.getMainPost().setTopic(topic);
        MainPost post = topic.getMainPost();
        post.setCreateTime(new Date());
        post.setUser(topic.getUser());
        post.setPostTitle(topic.getTopicTitle());
        post.setBoardId(topic.getBoardId());
        postDao.save(topic.getMainPost());

        User user = topic.getUser();
        user.setCredit(user.getCredit()+10);
        userDao.update(user);
    }

    // 删除一个主题帖
    public void removeTopic(int topicId){
        Topic topic = topicDao.get(topicId);

        Board board = (Board)boardDao.get(topic.getBoardId());
        board.setTopicNum(board.getTopicNum()-1);

        User user = topic.getUser();
        user.setCredit(user.getCredit()-50);

        topicDao.remove(topic);
        postDao.deteleTopicPost(topicId);
    }

    // 添加一个回复帖子
    public void addPost(Post post){
        postDao.save(post);

        User user = post.getUser();
        user.setCredit(user.getCredit()+5);
        userDao.update(user);

        Topic topic = topicDao.get(post.getTopic().getTopicId());
        topic.setReplies(topic.getReplies()+1);
        topic.setLastPost(new Date());
    }

    // 删除一个回复帖子
    public void removePost(Post postId){
        Post post = postDao.get(postId);
        postDao.remove(post);

        Topic topic = topicDao.get(post.getTopic().getTopicId());
        topic.setReplies(topic.getReplies()-1);

        User user = post.getUser();
        user.setCredit(user.getCredit()-20);
    }

    public void addBoard(Board board){
        boardDao.save(board);
    }

    public void removeBoard(int boardId){
        Board board = boardDao.get(boardId);
        boardDao.remove(board);
    }

    // 设定精华帖
    public void makeDigestTopic(int topicId){
        Topic topic = topicDao.get(topicId);
        topic.setDigest(Topic.DIGEST_TOPIC);

        User user = topic.getUser();
        user.setCredit(user.getCredit()+100);
    }
    /**
     * 获取论坛版块某一页主题帖，以最后回复时间降序排列
     * @param boardId
     * @return
     */
    public Page getPagedTopics(int boardId,int pageNo,int pageSize){
        return topicDao.getPagedTopics(boardId,pageNo,pageSize);
    }
    // 获取所有论坛
    public List<Board> getAllBoards(){
        return boardDao.loadall();
    }

    // 获取同主题每一页的帖子
    public Page getPagedPosts(int topicId,int pageNo,int pageSize){
        return postDao.getPagesPosts(topicId,pageNo,pageSize);
    }

    // 粗查询
    public Page queryTopicByTitle(String title,int pageNo,int pageSize){
        return topicDao.queryTopicByTitle(title,pageNo,pageSize);
    }

    // 根据boardID获取board
    public Board getBoardById(int boardId){
        return boardDao.get(boardId);
    }

    // 根据topicId获取Topic对象
    public Topic getTopicByTopicId(int topicId) {
        return topicDao.get(topicId);
    }

    // 根据postId获取post对象
    public Post getPostByPostId(int postId){
        return postDao.get(postId);
    }

    // 将用户设为论坛版块的管理员
    public void addBoardManage(int boardId,String userName){
        User user = userDao.getUserByUserName(userName);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }else{
            Board board = boardDao.get(boardId);
            user.getManBoards().add(board);
            userDao.update(user);
        }
    }

    // 更改主题帖
    public void updateTopic(Topic topic){
        topicDao.update(topic);
    }

    // 更改回复贴的内容
    public void updatePost(Post post){
        postDao.update(post);
    }


}
