package com.wind.boot.entity.dto;

import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 试卷问题表 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class PaperIssueDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 试卷id*/
    @NotNull(message = "paperId不能为空", groups = {Add.class})
    private Integer paperId;

    /** 题目id*/
    @NotNull(message = "issueId不能为空", groups = {Add.class})
    private Integer issueId;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
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
}