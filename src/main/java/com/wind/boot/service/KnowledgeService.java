package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Knowledge;
import com.wind.boot.entity.vo.KnowledgeVO;
import com.wind.boot.entity.dto.KnowledgeDTO;
import com.wind.boot.entity.dto.KnowledgeSearchDTO;

/**
 * 知识点 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface KnowledgeService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(KnowledgeDTO r);

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
    KnowledgeVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(KnowledgeDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<KnowledgeVO> list(KnowledgeSearchDTO r);
}