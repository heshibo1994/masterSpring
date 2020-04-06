package com.smart.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * 帖子PO类*/
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class Post extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "post_title")
    private int postTitle;
    @Column(name = "post_text")
    private int postText;
    @Column(name = "board_id")
    private int boardId;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "user_id")
    private User user;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(int postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostText() {
        return postText;
    }

    public void setPostText(int postText) {
        this.postText = postText;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
