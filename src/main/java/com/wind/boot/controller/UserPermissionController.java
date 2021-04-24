package com.wind.boot.controller;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.config.persistence.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.wind.boot.service.UserPermissionService;
import com.wind.boot.entity.po.UserPermission;
import com.wind.boot.entity.vo.UserPermissionVO;
import com.wind.boot.entity.dto.UserPermissionDTO;
import com.wind.boot.entity.dto.UserPermissionSearchDTO;

/**
 * 管理员权限分配 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/userPermission")
public class UserPermissionController{
	
	private final Logger logger = LoggerFactory.getLogger(UserPermissionController.class);
	
    @Autowired
    private UserPermissionService userPermissionService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody UserPermissionDTO r) {
        logger.info("UserPermissionController.save param: r is {}", r);
        int i = userPermissionService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("UserPermissionController.delete param: id is {}", id);
        int i = userPermissionService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("UserPermissionController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, userPermissionService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody UserPermissionDTO r) {
        logger.info("UserPermissionController.update param: r is {}", r);
        int i = userPermissionService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody UserPermissionSearchDTO r) {
        logger.info("UserPermissionController.list param: r is {}", r);
        List<UserPermissionVO> list = userPermissionService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody UserPermissionSearchDTO r){
        logger.info("UserPermissionController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<UserPermissionVO> list = userPermissionService.list(r);
        Page<UserPermissionVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}