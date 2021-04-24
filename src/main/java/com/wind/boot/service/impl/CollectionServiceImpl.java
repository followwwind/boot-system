package com.wind.boot.service.impl;

import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.dao.CollectionMapper;
import com.wind.boot.service.CollectionService;
import com.wind.boot.entity.po.Collection;
import com.wind.boot.entity.vo.CollectionVO;
import com.wind.boot.entity.dto.CollectionDTO;
import com.wind.boot.entity.dto.CollectionSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 知识点收藏表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class CollectionServiceImpl implements CollectionService{

	private Logger logger = LoggerFactory.getLogger(CollectionServiceImpl.class);

    @Autowired
    private CollectionMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) CollectionDTO r) {
    	logger.info("CollectionServiceImpl.save param: r is {}", r);
        Collection entity = new Collection();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("CollectionServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public CollectionVO get(Integer id) {
    	logger.info("CollectionServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) CollectionDTO r) {
    	logger.info("CollectionServiceImpl.update param: r is {}", r);
        Collection entity = new Collection();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<CollectionVO> list(CollectionSearchDTO r) {
    	logger.info("CollectionServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
