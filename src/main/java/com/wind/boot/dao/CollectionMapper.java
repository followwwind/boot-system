package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Collection;
import com.wind.boot.entity.vo.CollectionVO;
import com.wind.boot.entity.dto.CollectionSearchDTO;

/**
 * 知识点收藏表 dao
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@SqlMapper
public interface CollectionMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Collection r);

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
    CollectionVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Collection r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Collection r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<CollectionVO> list(CollectionSearchDTO r);

}