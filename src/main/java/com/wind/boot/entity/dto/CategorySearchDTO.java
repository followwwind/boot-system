package com.wind.boot.entity.dto;

import com.wind.boot.config.persistence.PageQuery;

/**
 * 标签 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class CategorySearchDTO extends PageQuery {

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