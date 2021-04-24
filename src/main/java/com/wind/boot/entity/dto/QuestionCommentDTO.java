package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 问答评论表 model
 * @author wind
 * @date 2021/04/18 19:12:31
 * @version V1.0
 */
public class QuestionCommentDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 用户id*/
    @NotNull(message = "userId不能为空", groups = {Add.class})
    private Integer userId;

    /** 知识点id*/
    @NotNull(message = "questionId不能为空", groups = {Add.class})
    private Integer questionId;

    /** 评论内容*/
    @NotBlank(message = "content不能为空", groups = {Add.class})
    private String content;


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

    public void setQuestionId(Integer questionId){
        this.questionId = questionId;
    }

    public Integer getQuestionId(){
        return this.questionId;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }
}