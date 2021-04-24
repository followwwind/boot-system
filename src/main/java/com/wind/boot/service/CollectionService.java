package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Collection;
import com.wind.boot.entity.vo.CollectionVO;
import com.wind.boot.entity.dto.CollectionDTO;
import com.wind.boot.entity.dto.CollectionSearchDTO;

/**
 * 知识点收藏表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface CollectionService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(CollectionDTO r);

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
    CollectionVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(CollectionDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<CollectionVO> list(CollectionSearchDTO r);
}