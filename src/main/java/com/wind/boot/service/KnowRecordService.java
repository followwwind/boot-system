package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.KnowRecord;
import com.wind.boot.entity.vo.KnowRecordVO;
import com.wind.boot.entity.dto.KnowRecordDTO;
import com.wind.boot.entity.dto.KnowRecordSearchDTO;

/**
 * 知识点浏览 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface KnowRecordService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(KnowRecordDTO r);

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
    KnowRecordVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(KnowRecordDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<KnowRecordVO> list(KnowRecordSearchDTO r);
}