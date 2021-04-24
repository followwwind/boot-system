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
import com.wind.boot.dao.LearnMapper;
import com.wind.boot.service.LearnService;
import com.wind.boot.entity.po.Learn;
import com.wind.boot.entity.vo.LearnVO;
import com.wind.boot.entity.dto.LearnDTO;
import com.wind.boot.entity.dto.LearnSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 学习 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class LearnServiceImpl implements LearnService{

	private Logger logger = LoggerFactory.getLogger(LearnServiceImpl.class);

    @Autowired
    private LearnMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) LearnDTO r) {
    	logger.info("LearnServiceImpl.save param: r is {}", r);
        Learn entity = new Learn();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("LearnServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public LearnVO get(Integer id) {
    	logger.info("LearnServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) LearnDTO r) {
    	logger.info("LearnServiceImpl.update param: r is {}", r);
        Learn entity = new Learn();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<LearnVO> list(LearnSearchDTO r) {
    	logger.info("LearnServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
