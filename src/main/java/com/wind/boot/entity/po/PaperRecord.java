package com.wind.boot.entity.po;

import java.util.Date;
import com.wind.boot.config.persistence.BasePO;

/**
 * 试卷小测记录 model
 * @author wind
 * @date 2021/04/18 19:05:24
 * @version V1.0
 */
public class PaperRecord extends BasePO {

    private Integer id;

    /** 用户id*/
    private Integer userId;

    /** 试卷id*/
    private Integer paperId;

    /** 题目id*/
    private Integer issueId;

    /** 答案，A,B,C,D*/
    private String answer;

    /** 创建时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setPaperId(Integer paperId){
        this.paperId = paperId;
    }

    public Integer getPaperId(){
        return this.paperId;
    }

    public void setIssueId(Integer issueId){
        this.issueId = issueId;
    }

    public Integer getIssueId(){
        return this.issueId;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return this.answer;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}