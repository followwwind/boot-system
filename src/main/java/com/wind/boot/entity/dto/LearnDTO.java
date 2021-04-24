package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 学习 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class LearnDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 标题*/
    @NotBlank(message = "title不能为空", groups = {Add.class})
    private String title;

    /** 简介*/
    @NotBlank(message = "info不能为空", groups = {Add.class})
    private String info;

    /** 超链接*/
    @NotBlank(message = "url不能为空", groups = {Add.class})
    private String url;


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
}