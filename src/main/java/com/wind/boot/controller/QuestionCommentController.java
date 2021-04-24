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
import com.wind.boot.service.QuestionCommentService;
import com.wind.boot.entity.po.QuestionComment;
import com.wind.boot.entity.vo.QuestionCommentVO;
import com.wind.boot.entity.dto.QuestionCommentDTO;
import com.wind.boot.entity.dto.QuestionCommentSearchDTO;

/**
 * 问答评论表 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/questionComment")
public class QuestionCommentController{
	
	private final Logger logger = LoggerFactory.getLogger(QuestionCommentController.class);
	
    @Autowired
    private QuestionCommentService questionCommentService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody QuestionCommentDTO r) {
        logger.info("QuestionCommentController.save param: r is {}", r);
        int i = questionCommentService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("QuestionCommentController.delete param: id is {}", id);
        int i = questionCommentService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("QuestionCommentController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, questionCommentService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody QuestionCommentDTO r) {
        logger.info("QuestionCommentController.update param: r is {}", r);
        int i = questionCommentService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody QuestionCommentSearchDTO r) {
        logger.info("QuestionCommentController.list param: r is {}", r);
        List<QuestionCommentVO> list = questionCommentService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody QuestionCommentSearchDTO r){
        logger.info("QuestionCommentController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<QuestionCommentVO> list = questionCommentService.list(r);
        Page<QuestionCommentVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}