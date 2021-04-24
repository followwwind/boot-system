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
import com.wind.boot.dao.PaperMapper;
import com.wind.boot.service.PaperService;
import com.wind.boot.entity.po.Paper;
import com.wind.boot.entity.vo.PaperVO;
import com.wind.boot.entity.dto.PaperDTO;
import com.wind.boot.entity.dto.PaperSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 试卷 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class PaperServiceImpl implements PaperService{

	private Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);

    @Autowired
    private PaperMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) PaperDTO r) {
    	logger.info("PaperServiceImpl.save param: r is {}", r);
        Paper entity = new Paper();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("PaperServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public PaperVO get(Integer id) {
    	logger.info("PaperServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) PaperDTO r) {
    	logger.info("PaperServiceImpl.update param: r is {}", r);
        Paper entity = new Paper();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<PaperVO> list(PaperSearchDTO r) {
    	logger.info("PaperServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
