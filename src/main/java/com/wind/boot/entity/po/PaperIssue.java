package com.wind.boot.entity.po;

import com.wind.boot.config.persistence.BasePO;

/**
 * 试卷问题表 model
 * @author wind
 * @date 2021/04/18 19:05:24
 * @version V1.0
 */
public class PaperIssue extends BasePO {

    private Integer id;

    /** 试卷id*/
    private Integer paperId;

    /** 题目id*/
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