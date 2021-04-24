package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.PaperRecord;
import com.wind.boot.entity.vo.PaperRecordVO;
import com.wind.boot.entity.dto.PaperRecordDTO;
import com.wind.boot.entity.dto.PaperRecordSearchDTO;

/**
 * 试卷小测记录 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface PaperRecordService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(PaperRecordDTO r);

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
    PaperRecordVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(PaperRecordDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<PaperRecordVO> list(PaperRecordSearchDTO r);
}