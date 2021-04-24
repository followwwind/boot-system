package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Paper;
import com.wind.boot.entity.vo.PaperVO;
import com.wind.boot.entity.dto.PaperDTO;
import com.wind.boot.entity.dto.PaperSearchDTO;

/**
 * 试卷 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface PaperService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(PaperDTO r);

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
    PaperVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(PaperDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<PaperVO> list(PaperSearchDTO r);
}