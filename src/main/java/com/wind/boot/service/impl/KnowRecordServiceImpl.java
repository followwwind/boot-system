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
import com.wind.boot.dao.KnowRecordMapper;
import com.wind.boot.service.KnowRecordService;
import com.wind.boot.entity.po.KnowRecord;
import com.wind.boot.entity.vo.KnowRecordVO;
import com.wind.boot.entity.dto.KnowRecordDTO;
import com.wind.boot.entity.dto.KnowRecordSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 知识点浏览 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class KnowRecordServiceImpl implements KnowRecordService{

	private Logger logger = LoggerFactory.getLogger(KnowRecordServiceImpl.class);

    @Autowired
    private KnowRecordMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) KnowRecordDTO r) {
    	logger.info("KnowRecordServiceImpl.save param: r is {}", r);
        KnowRecord entity = new KnowRecord();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("KnowRecordServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public KnowRecordVO get(Integer id) {
    	logger.info("KnowRecordServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) KnowRecordDTO r) {
    	logger.info("KnowRecordServiceImpl.update param: r is {}", r);
        KnowRecord entity = new KnowRecord();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<KnowRecordVO> list(KnowRecordSearchDTO r) {
    	logger.info("KnowRecordServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
