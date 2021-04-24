package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.QuestionComment;
import com.wind.boot.entity.vo.QuestionCommentVO;
import com.wind.boot.entity.dto.QuestionCommentSearchDTO;

/**
 * 问答评论表 dao
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@SqlMapper
public interface QuestionCommentMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(QuestionComment r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    QuestionCommentVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(QuestionComment r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(QuestionComment r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<QuestionCommentVO> list(QuestionCommentSearchDTO r);

}