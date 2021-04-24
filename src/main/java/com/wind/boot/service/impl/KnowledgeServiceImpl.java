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
import com.wind.boot.dao.KnowledgeMapper;
import com.wind.boot.service.KnowledgeService;
import com.wind.boot.entity.po.Knowledge;
import com.wind.boot.entity.vo.KnowledgeVO;
import com.wind.boot.entity.dto.KnowledgeDTO;
import com.wind.boot.entity.dto.KnowledgeSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 知识点 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService{

	private Logger logger = LoggerFactory.getLogger(KnowledgeServiceImpl.class);

    @Autowired
    private KnowledgeMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) KnowledgeDTO r) {
    	logger.info("KnowledgeServiceImpl.save param: r is {}", r);
        Knowledge entity = new Knowledge();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("KnowledgeServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public KnowledgeVO get(Integer id) {
    	logger.info("KnowledgeServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) KnowledgeDTO r) {
    	logger.info("KnowledgeServiceImpl.update param: r is {}", r);
        Knowledge entity = new Knowledge();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<KnowledgeVO> list(KnowledgeSearchDTO r) {
    	logger.info("KnowledgeServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
