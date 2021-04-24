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
import com.wind.boot.dao.QuestionCommentMapper;
import com.wind.boot.service.QuestionCommentService;
import com.wind.boot.entity.po.QuestionComment;
import com.wind.boot.entity.vo.QuestionCommentVO;
import com.wind.boot.entity.dto.QuestionCommentDTO;
import com.wind.boot.entity.dto.QuestionCommentSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 问答评论表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class QuestionCommentServiceImpl implements QuestionCommentService{

	private Logger logger = LoggerFactory.getLogger(QuestionCommentServiceImpl.class);

    @Autowired
    private QuestionCommentMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) QuestionCommentDTO r) {
    	logger.info("QuestionCommentServiceImpl.save param: r is {}", r);
        QuestionComment entity = new QuestionComment();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("QuestionCommentServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public QuestionCommentVO get(Integer id) {
    	logger.info("QuestionCommentServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) QuestionCommentDTO r) {
    	logger.info("QuestionCommentServiceImpl.update param: r is {}", r);
        QuestionComment entity = new QuestionComment();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<QuestionCommentVO> list(QuestionCommentSearchDTO r) {
    	logger.info("QuestionCommentServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
