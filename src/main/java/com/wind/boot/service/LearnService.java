package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Learn;
import com.wind.boot.entity.vo.LearnVO;
import com.wind.boot.entity.dto.LearnDTO;
import com.wind.boot.entity.dto.LearnSearchDTO;

/**
 * 学习 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface LearnService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(LearnDTO r);

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
    LearnVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(LearnDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<LearnVO> list(LearnSearchDTO r);
}