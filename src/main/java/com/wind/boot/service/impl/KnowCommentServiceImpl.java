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
import com.wind.boot.dao.KnowCommentMapper;
import com.wind.boot.service.KnowCommentService;
import com.wind.boot.entity.po.KnowComment;
import com.wind.boot.entity.vo.KnowCommentVO;
import com.wind.boot.entity.dto.KnowCommentDTO;
import com.wind.boot.entity.dto.KnowCommentSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 知识点评论表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class KnowCommentServiceImpl implements KnowCommentService{

	private Logger logger = LoggerFactory.getLogger(KnowCommentServiceImpl.class);

    @Autowired
    private KnowCommentMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) KnowCommentDTO r) {
    	logger.info("KnowCommentServiceImpl.save param: r is {}", r);
        KnowComment entity = new KnowComment();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("KnowCommentServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public KnowCommentVO get(Integer id) {
    	logger.info("KnowCommentServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) KnowCommentDTO r) {
    	logger.info("KnowCommentServiceImpl.update param: r is {}", r);
        KnowComment entity = new KnowComment();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<KnowCommentVO> list(KnowCommentSearchDTO r) {
    	logger.info("KnowCommentServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
