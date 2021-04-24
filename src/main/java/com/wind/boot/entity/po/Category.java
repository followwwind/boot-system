package com.wind.boot.entity.po;

import com.wind.boot.config.persistence.BasePO;

/**
 * 标签 model
 * @author wind
 * @date 2021/04/18 19:05:23
 * @version V1.0
 */
public class Category extends BasePO {

    private Integer id;

    /** 名称*/
    private String name;

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
}