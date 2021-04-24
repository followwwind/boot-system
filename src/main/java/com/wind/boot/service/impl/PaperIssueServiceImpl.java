package com.wind.boot.service.impl;

import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.dao.PaperIssueMapper;
import com.wind.boot.service.PaperIssueService;
import com.wind.boot.entity.po.PaperIssue;
import com.wind.boot.entity.vo.PaperIssueVO;
import com.wind.boot.entity.dto.PaperIssueDTO;
import com.wind.boot.entity.dto.PaperIssueSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 试卷问题表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class PaperIssueServiceImpl implements PaperIssueService{

	private Logger logger = LoggerFactory.getLogger(PaperIssueServiceImpl.class);

    @Autowired
    private PaperIssueMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) PaperIssueDTO r) {
    	logger.info("PaperIssueServiceImpl.save param: r is {}", r);
        PaperIssue entity = new PaperIssue();
        BeanUtil.copy(r, entity);
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("PaperIssueServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public PaperIssueVO get(Integer id) {
    	logger.info("PaperIssueServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) PaperIssueDTO r) {
    	logger.info("PaperIssueServiceImpl.update param: r is {}", r);
        PaperIssue entity = new PaperIssue();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<PaperIssueVO> list(PaperIssueSearchDTO r) {
    	logger.info("PaperIssueServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
