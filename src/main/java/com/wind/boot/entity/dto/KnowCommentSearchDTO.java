package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.PageQuery;

/**
 * 知识点评论表 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class KnowCommentSearchDTO extends PageQuery {

    private Integer id;

    /** 用户id*/
    private Integer userId;

    /** 知识点id*/
    private Integer knowId;

    /** 评论内容*/
    private String content;

    /** 评论时间*/
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

    public void setKnowId(Integer knowId){
        this.knowId = knowId;
    }

    public Integer getKnowId(){
        return this.knowId;
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