package com.wind.boot.entity.po;

import com.wind.boot.config.persistence.BasePO;

/**
 * 管理员权限分配 model
 * @author wind
 * @date 2021/04/18 19:05:24
 * @version V1.0
 */
public class UserPermission extends BasePO {

    private Integer id;

    /** 管理员id*/
    private Integer userId;

    /** 类型，1：用户管理，2：内容管理，3：学习管理*/
    private Integer type;

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

    public void setType(Integer type){
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }
}