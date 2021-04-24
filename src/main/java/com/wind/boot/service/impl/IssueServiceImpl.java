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
import com.wind.boot.dao.IssueMapper;
import com.wind.boot.service.IssueService;
import com.wind.boot.entity.po.Issue;
import com.wind.boot.entity.vo.IssueVO;
import com.wind.boot.entity.dto.IssueDTO;
import com.wind.boot.entity.dto.IssueSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 题目 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class IssueServiceImpl implements IssueService{

	private Logger logger = LoggerFactory.getLogger(IssueServiceImpl.class);

    @Autowired
    private IssueMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) IssueDTO r) {
    	logger.info("IssueServiceImpl.save param: r is {}", r);
        Issue entity = new Issue();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("IssueServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public IssueVO get(Integer id) {
    	logger.info("IssueServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) IssueDTO r) {
    	logger.info("IssueServiceImpl.update param: r is {}", r);
        Issue entity = new Issue();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<IssueVO> list(IssueSearchDTO r) {
    	logger.info("IssueServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
