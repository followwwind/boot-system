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
import com.wind.boot.dao.AnswerMapper;
import com.wind.boot.service.AnswerService;
import com.wind.boot.entity.po.Answer;
import com.wind.boot.entity.vo.AnswerVO;
import com.wind.boot.entity.dto.AnswerDTO;
import com.wind.boot.entity.dto.AnswerSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 答案选项表 service
 * @author wind
 * @date 2021/04/18 19:14:55
 * @version V1.0
 */
@Service
public class AnswerServiceImpl implements AnswerService{

	private Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);

    @Autowired
    private AnswerMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) AnswerDTO r) {
    	logger.info("AnswerServiceImpl.save param: r is {}", r);
        Answer entity = new Answer();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("AnswerServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public AnswerVO get(Integer id) {
    	logger.info("AnswerServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) AnswerDTO r) {
    	logger.info("AnswerServiceImpl.update param: r is {}", r);
        Answer entity = new Answer();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<AnswerVO> list(AnswerSearchDTO r) {
    	logger.info("AnswerServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
