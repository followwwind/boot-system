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
import com.wind.boot.dao.PaperRecordMapper;
import com.wind.boot.service.PaperRecordService;
import com.wind.boot.entity.po.PaperRecord;
import com.wind.boot.entity.vo.PaperRecordVO;
import com.wind.boot.entity.dto.PaperRecordDTO;
import com.wind.boot.entity.dto.PaperRecordSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 试卷小测记录 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class PaperRecordServiceImpl implements PaperRecordService{

	private Logger logger = LoggerFactory.getLogger(PaperRecordServiceImpl.class);

    @Autowired
    private PaperRecordMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) PaperRecordDTO r) {
    	logger.info("PaperRecordServiceImpl.save param: r is {}", r);
        PaperRecord entity = new PaperRecord();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("PaperRecordServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public PaperRecordVO get(Integer id) {
    	logger.info("PaperRecordServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) PaperRecordDTO r) {
    	logger.info("PaperRecordServiceImpl.update param: r is {}", r);
        PaperRecord entity = new PaperRecord();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<PaperRecordVO> list(PaperRecordSearchDTO r) {
    	logger.info("PaperRecordServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
