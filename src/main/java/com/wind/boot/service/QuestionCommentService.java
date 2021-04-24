package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.QuestionComment;
import com.wind.boot.entity.vo.QuestionCommentVO;
import com.wind.boot.entity.dto.QuestionCommentDTO;
import com.wind.boot.entity.dto.QuestionCommentSearchDTO;

/**
 * 问答评论表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface QuestionCommentService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(QuestionCommentDTO r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    QuestionCommentVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(QuestionCommentDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<QuestionCommentVO> list(QuestionCommentSearchDTO r);
}