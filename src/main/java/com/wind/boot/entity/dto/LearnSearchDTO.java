package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.PageQuery;

/**
 * 学习 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class LearnSearchDTO extends PageQuery {

    private Integer id;

    /** 标题*/
    private String title;

    /** 简介*/
    private String info;

    /** 超链接*/
    private String url;

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

    public void setInfo(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}