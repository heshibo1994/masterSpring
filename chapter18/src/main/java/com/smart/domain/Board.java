package com.smart.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * 论坛版块PO类*/
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_board")
public class Board extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;
    @Column(name = "board_name")
    private int boardName;
    @Column(name = "board_desc")
    private int boardDesc;
    @Column(name = "topic_num")
    private int topicNum;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getBoardName() {
        return boardName;
    }

    public void setBoardName(int boardName) {
        this.boardName = boardName;
    }

    public int getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(int boardDesc) {
        this.boardDesc = boardDesc;
    }

    public int getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(int topicNum) {
        this.topicNum = topicNum;
    }
}
