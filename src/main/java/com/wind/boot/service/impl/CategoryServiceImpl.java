package com.wind.boot.service.impl;

import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.dao.CategoryMapper;
import com.wind.boot.service.CategoryService;
import com.wind.boot.entity.po.Category;
import com.wind.boot.entity.vo.CategoryVO;
import com.wind.boot.entity.dto.CategoryDTO;
import com.wind.boot.entity.dto.CategorySearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 标签 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService{

	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) CategoryDTO r) {
    	logger.info("CategoryServiceImpl.save param: r is {}", r);
        Category entity = new Category();
        BeanUtil.copy(r, entity);
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("CategoryServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public CategoryVO get(Integer id) {
    	logger.info("CategoryServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) CategoryDTO r) {
    	logger.info("CategoryServiceImpl.update param: r is {}", r);
        Category entity = new Category();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<CategoryVO> list(CategorySearchDTO r) {
    	logger.info("CategoryServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
