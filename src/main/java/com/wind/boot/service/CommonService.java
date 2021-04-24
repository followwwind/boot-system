package com.wind.boot.service;

import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;
import com.wind.boot.config.message.JsonResult;

/**
 * @Title: UserService
 * @Package com.wind.boot.service
 * @Description: 用户业务接口
 * @author wind
 * @date 2020/04/06 16:41:40
 * @version V1.0
 */
public interface CommonService {

    /**
     * 登录
     * @param r
     * @return
     */
    JsonResult login(LoginDTO r);

    /**
     * 注册
     * @param r
     * @return
     */
    JsonResult reg(RegisterDTO r);

}

