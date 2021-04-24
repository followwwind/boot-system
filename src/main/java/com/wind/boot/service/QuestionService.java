package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Question;
import com.wind.boot.entity.vo.QuestionVO;
import com.wind.boot.entity.dto.QuestionDTO;
import com.wind.boot.entity.dto.QuestionSearchDTO;

/**
 * 问答 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface QuestionService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(QuestionDTO r);

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
    QuestionVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(QuestionDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<QuestionVO> list(QuestionSearchDTO r);
}