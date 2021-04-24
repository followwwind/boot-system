package com.wind.boot.service.impl;

import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.dao.UserPermissionMapper;
import com.wind.boot.service.UserPermissionService;
import com.wind.boot.entity.po.UserPermission;
import com.wind.boot.entity.vo.UserPermissionVO;
import com.wind.boot.entity.dto.UserPermissionDTO;
import com.wind.boot.entity.dto.UserPermissionSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 管理员权限分配 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService{

	private Logger logger = LoggerFactory.getLogger(UserPermissionServiceImpl.class);

    @Autowired
    private UserPermissionMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) UserPermissionDTO r) {
    	logger.info("UserPermissionServiceImpl.save param: r is {}", r);
        UserPermission entity = new UserPermission();
        BeanUtil.copy(r, entity);
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("UserPermissionServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public UserPermissionVO get(Integer id) {
    	logger.info("UserPermissionServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) UserPermissionDTO r) {
    	logger.info("UserPermissionServiceImpl.update param: r is {}", r);
        UserPermission entity = new UserPermission();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<UserPermissionVO> list(UserPermissionSearchDTO r) {
    	logger.info("UserPermissionServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
