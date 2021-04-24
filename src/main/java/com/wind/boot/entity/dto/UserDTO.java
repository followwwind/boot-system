package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户表 model
 * @author wind
 * @date 2021/04/18 19:12:31
 * @version V1.0
 */
public class UserDTO extends BaseDTO {

    /** id*/
    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 账号*/
    @NotBlank(message = "username不能为空", groups = {Add.class})
    private String username;

    /** 密码*/
    @NotBlank(message = "password不能为空", groups = {Add.class})
    private String password;

    /** 性别*/
    @NotBlank(message = "sex不能为空", groups = {Add.class})
    private String sex;

    /** 昵称*/
    @NotBlank(message = "nickname不能为空", groups = {Add.class})
    private String nickname;

    /** 用户类型，1：超级管理员，2:管理员, 3用户*/
    @NotNull(message = "type不能为空", groups = {Add.class})
    private Integer type;

    /** 状态，0：正常，1：禁止评论，2：禁止发表知识点，3：用户永久封号*/
    @NotNull(message = "status不能为空", groups = {Add.class})
    private Integer status;


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
}