package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.PageQuery;

/**
 * 用户表 model
 * @author wind
 * @date 2021/04/18 19:12:31
 * @version V1.0
 */
public class UserSearchDTO extends PageQuery {

    /** id*/
    private Integer id;

    /** 账号*/
    private String username;

    /** 密码*/
    private String password;

    /** 性别*/
    private String sex;

    /** 昵称*/
    private String nickname;

    /** 用户类型，1：超级管理员，2:管理员, 3用户*/
    private Integer type;

    /** 状态，0：正常，1：禁止评论，2：禁止发表知识点，3：用户永久封号*/
    private Integer status;

    /** 创建时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return this.sex;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setType(Integer type){
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}