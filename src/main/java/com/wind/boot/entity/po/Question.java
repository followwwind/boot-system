package com.wind.boot.entity.po;

import java.util.Date;
import com.wind.boot.config.persistence.BasePO;

/**
 * 问答 model
 * @author wind
 * @date 2021/04/18 19:05:24
 * @version V1.0
 */
public class Question extends BasePO {

    private Integer id;

    /** 标题*/
    private String title;

    /** 用户id*/
    private Integer userId;

    /** 问题内容*/
    private String content;

    /** 创建时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
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