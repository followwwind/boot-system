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
import com.wind.boot.dao.QuestionMapper;
import com.wind.boot.service.QuestionService;
import com.wind.boot.entity.po.Question;
import com.wind.boot.entity.vo.QuestionVO;
import com.wind.boot.entity.dto.QuestionDTO;
import com.wind.boot.entity.dto.QuestionSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 问答 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService{

	private Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    private QuestionMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) QuestionDTO r) {
    	logger.info("QuestionServiceImpl.save param: r is {}", r);
        Question entity = new Question();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("QuestionServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public QuestionVO get(Integer id) {
    	logger.info("QuestionServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) QuestionDTO r) {
    	logger.info("QuestionServiceImpl.update param: r is {}", r);
        Question entity = new Question();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<QuestionVO> list(QuestionSearchDTO r) {
    	logger.info("QuestionServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
