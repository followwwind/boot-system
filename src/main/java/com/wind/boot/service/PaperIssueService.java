package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.PaperIssue;
import com.wind.boot.entity.vo.PaperIssueVO;
import com.wind.boot.entity.dto.PaperIssueDTO;
import com.wind.boot.entity.dto.PaperIssueSearchDTO;

/**
 * 试卷问题表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface PaperIssueService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(PaperIssueDTO r);

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
    PaperIssueVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(PaperIssueDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<PaperIssueVO> list(PaperIssueSearchDTO r);
}