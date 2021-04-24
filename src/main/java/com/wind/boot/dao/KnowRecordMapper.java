package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.KnowRecord;
import com.wind.boot.entity.vo.KnowRecordVO;
import com.wind.boot.entity.dto.KnowRecordSearchDTO;

/**
 * 知识点浏览 dao
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@SqlMapper
public interface KnowRecordMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(KnowRecord r);

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
    KnowRecordVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(KnowRecord r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(KnowRecord r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<KnowRecordVO> list(KnowRecordSearchDTO r);

}