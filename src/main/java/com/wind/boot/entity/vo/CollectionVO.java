package com.wind.boot.entity.vo;

import java.util.Date;
import com.wind.boot.config.persistence.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 知识点收藏表 model
 * @author wind
 * @date 2021/04/18 19:05:23
 * @version V1.0
 */
public class CollectionVO extends BaseVO {

    private Integer id;

    /** 知识点id*/
    private Integer knowId;

    /** 用户id*/
    private Integer userId;

    /** 收藏时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setKnowId(Integer knowId){
        this.knowId = knowId;
    }

    public Integer getKnowId(){
        return this.knowId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}