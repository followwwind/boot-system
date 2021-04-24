package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Issue;
import com.wind.boot.entity.vo.IssueVO;
import com.wind.boot.entity.dto.IssueSearchDTO;

/**
 * 题目 dao
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@SqlMapper
public interface IssueMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Issue r);

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
    IssueVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Issue r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Issue r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<IssueVO> list(IssueSearchDTO r);

}