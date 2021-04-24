package com.wind.boot.service.impl;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.wind.boot.dao.UserMapper;
import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;
import com.wind.boot.entity.enums.UserStatusType;
import com.wind.boot.entity.po.User;
import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.service.CommonService;
import com.wind.boot.config.message.JsonResult;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Title: UserServiceImpl
 * @Package com.wind.boot.service.impl
 * @Description: 用户业务处理
 * @author wind
 * @date 2020/04/06 16:41:40
 * @version V1.0
 */
@Service
public class CommonServiceImpl implements CommonService {

	private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private UserMapper mapper;

    @Override
    public JsonResult login(@FluentValid LoginDTO r) {
        logger.info("UserServiceImpl.login param: r is {}", r);
        String username = r.getUsername();
        UserVO vo = mapper.findByName(username);
        if(vo == null){
            return HttpCode.NAME_OR_PWD_ERR.getJsonResult();
        }
        String pwd = MD5Util.getMD5String(r.getPassword());
        if(pwd.equals(vo.getPassword())){
            vo.setPassword("");
            return new JsonResult(HttpCode.OK, vo);
        }
        return HttpCode.NAME_OR_PWD_ERR.getJsonResult();
    }


    @Override
    public JsonResult reg(@FluentValid RegisterDTO r) {
        logger.info("UserServiceImpl.reg param: r is {}", r);
        String username = r.getUsername();
        UserVO vo = mapper.findByName(username);
        if(vo != null){
            return HttpCode.LOGIN_NAME_ALREADY_EXISTS.getJsonResult();
        }
        User entity = new User();
        BeanUtil.copy(r, entity);
        entity.setPassword(MD5Util.getMD5String(r.getPassword()));
        entity.setStatus(UserStatusType.NORMAL.getCode());
        entity.setCreateTime(new Date());
        int i = mapper.insert(entity);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }
    
}

