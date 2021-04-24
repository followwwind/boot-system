package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Answer;
import com.wind.boot.entity.vo.AnswerVO;
import com.wind.boot.entity.dto.AnswerDTO;
import com.wind.boot.entity.dto.AnswerSearchDTO;

/**
 * 答案选项表 service
 * @author wind
 * @date 2021/04/18 19:14:55
 * @version V1.0
 */
public interface AnswerService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(AnswerDTO r);

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
    AnswerVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(AnswerDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<AnswerVO> list(AnswerSearchDTO r);
}