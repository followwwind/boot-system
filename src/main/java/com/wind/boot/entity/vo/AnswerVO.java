package com.wind.boot.entity.vo;

import java.util.Date;
import com.wind.boot.config.persistence.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 答案选项表 model
 * @author wind
 * @date 2021/04/18 19:05:23
 * @version V1.0
 */
public class AnswerVO extends BaseVO {

    private Integer id;

    /** 选项，A，B，C，D*/
    private String name;

    /** 题目id*/
    private Integer issueId;

    /** 内容*/
    private String content;

    /** 创建时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
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