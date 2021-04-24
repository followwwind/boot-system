package com.wind.boot.entity.vo;

import java.util.Date;
import com.wind.boot.config.persistence.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷 model
 * @author wind
 * @date 2021/04/18 19:05:24
 * @version V1.0
 */
public class PaperVO extends BaseVO {

    private Integer id;

    /** 试卷名称*/
    private String name;

    /** 关键词搜索*/
    private String keyword;

    /** 题目数量*/
    private Integer count;

    /** 时间*/
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

    public void setKeyword(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword(){
        return this.keyword;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public Integer getCount(){
        return this.count;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}