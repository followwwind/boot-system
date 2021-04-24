package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 答案选项表 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class AnswerDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 选项，A，B，C，D*/
    @NotBlank(message = "name不能为空", groups = {Add.class})
    private String name;

    /** 题目id*/
    @NotNull(message = "issueId不能为空", groups = {Add.class})
    private Integer issueId;

    /** 内容*/
    @NotBlank(message = "content不能为空", groups = {Add.class})
    private String content;


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

    public void setIssueId(Integer issueId){
        this.issueId = issueId;
    }

    public Integer getIssueId(){
        return this.issueId;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }
}