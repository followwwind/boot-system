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
import com.wind.boot.service.LearnService;
import com.wind.boot.entity.po.Learn;
import com.wind.boot.entity.vo.LearnVO;
import com.wind.boot.entity.dto.LearnDTO;
import com.wind.boot.entity.dto.LearnSearchDTO;

/**
 * 学习 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/learn")
public class LearnController{
	
	private final Logger logger = LoggerFactory.getLogger(LearnController.class);
	
    @Autowired
    private LearnService learnService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody LearnDTO r) {
        logger.info("LearnController.save param: r is {}", r);
        int i = learnService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("LearnController.delete param: id is {}", id);
        int i = learnService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("LearnController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, learnService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody LearnDTO r) {
        logger.info("LearnController.update param: r is {}", r);
        int i = learnService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody LearnSearchDTO r) {
        logger.info("LearnController.list param: r is {}", r);
        List<LearnVO> list = learnService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody LearnSearchDTO r){
        logger.info("LearnController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<LearnVO> list = learnService.list(r);
        Page<LearnVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}