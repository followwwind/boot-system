package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Answer;
import com.wind.boot.entity.vo.AnswerVO;
import com.wind.boot.entity.dto.AnswerSearchDTO;

/**
 * 答案选项表 dao
 * @author wind
 * @date 2021/04/18 19:14:55
 * @version V1.0
 */
@SqlMapper
public interface AnswerMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Answer r);

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
    AnswerVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Answer r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Answer r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<AnswerVO> list(AnswerSearchDTO r);

}