package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 试卷小测记录 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class PaperRecordDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 用户id*/
    @NotNull(message = "userId不能为空", groups = {Add.class})
    private Integer userId;

    /** 试卷id*/
    @NotNull(message = "paperId不能为空", groups = {Add.class})
    private Integer paperId;

    /** 题目id*/
    @NotNull(message = "issueId不能为空", groups = {Add.class})
    private Integer issueId;

    /** 答案，A,B,C,D*/
    @NotBlank(message = "answer不能为空", groups = {Add.class})
    private String answer;


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

    public void setPaperId(Integer paperId){
        this.paperId = paperId;
    }

    public Integer getPaperId(){
        return this.paperId;
    }

    public void setIssueId(Integer issueId){
        this.issueId = issueId;
    }

    public Integer getIssueId(){
        return this.issueId;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return this.answer;
    }
}