package com.wind.boot.controller;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;
import com.wind.boot.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: UserController
 * @Package com.wind.boot.controller
 * @Description: 用户接口
 * @author wind
 * @date 2020/04/06 16:41:40
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Autowired
    private CommonService userService;

    /**
     * 添加记录接口
     * user/save
     * @param r
     * @return
     */
    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginDTO r) {
    	logger.info("UserController.login param: r is {}", r);
        return userService.login(r);
    }


    @PostMapping("/reg")
    public JsonResult reg(@RequestBody RegisterDTO r) {
        logger.info("UserController.reg param: r is {}", r);
        return userService.reg(r);
    }
}
