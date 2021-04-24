package com.wind.boot.entity.vo;

import java.util.Date;
import com.wind.boot.config.persistence.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 知识点 model
 * @author wind
 * @date 2021/04/18 19:05:23
 * @version V1.0
 */
public class KnowledgeVO extends BaseVO {

    private Integer id;

    /** 标题*/
    private String title;

    /** 用户id*/
    private Integer userId;

    /** 知识点类别*/
    private Integer categoryId;

    /** 知识点内容*/
    private String content;

    /** 是否分享，0：否，1：是*/
    private Integer isShare;

    /** 创建时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
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

    public void setCategoryId(Integer categoryId){
        this.categoryId = categoryId;
    }

    public Integer getCategoryId(){
        return this.categoryId;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setIsShare(Integer isShare){
        this.isShare = isShare;
    }

    public Integer getIsShare(){
        return this.isShare;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}