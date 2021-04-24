package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Category;
import com.wind.boot.entity.vo.CategoryVO;
import com.wind.boot.entity.dto.CategoryDTO;
import com.wind.boot.entity.dto.CategorySearchDTO;

/**
 * 标签 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface CategoryService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(CategoryDTO r);

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
    CategoryVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(CategoryDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<CategoryVO> list(CategorySearchDTO r);
}