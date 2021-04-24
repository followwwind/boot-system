package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Issue;
import com.wind.boot.entity.vo.IssueVO;
import com.wind.boot.entity.dto.IssueDTO;
import com.wind.boot.entity.dto.IssueSearchDTO;

/**
 * 题目 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface IssueService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(IssueDTO r);

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
    IssueVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(IssueDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<IssueVO> list(IssueSearchDTO r);
}