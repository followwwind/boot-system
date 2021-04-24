package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 试卷 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class PaperDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 试卷名称*/
    @NotBlank(message = "name不能为空", groups = {Add.class})
    private String name;

    /** 关键词搜索*/
    @NotBlank(message = "keyword不能为空", groups = {Add.class})
    private String keyword;

    /** 题目数量*/
    @NotNull(message = "count不能为空", groups = {Add.class})
    private Integer count;


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
}