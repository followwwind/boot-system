package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.PageQuery;

/**
 * 答案选项表 model
 * @author wind
 * @date 2021/04/18 19:14:55
 * @version V1.0
 */
public class AnswerSearchDTO extends PageQuery {

    private Integer id;

    /** 选项，A，B，C，D*/
    private String name;

    /** 题目id*/
    private Integer issueId;

    /** 内容*/
    private String content;

    /** 创建时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setIssueId(Integer issueId){
        this.issueId = issueId;
    }

    public Integer getIssueId(){
        return this.issueId;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}