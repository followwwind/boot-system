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
import com.wind.boot.service.AnswerService;
import com.wind.boot.entity.po.Answer;
import com.wind.boot.entity.vo.AnswerVO;
import com.wind.boot.entity.dto.AnswerDTO;
import com.wind.boot.entity.dto.AnswerSearchDTO;

/**
 * 答案选项表 controller
 * @author wind
 * @date 2021/04/18 19:14:55
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/answer")
public class AnswerController{
	
	private final Logger logger = LoggerFactory.getLogger(AnswerController.class);
	
    @Autowired
    private AnswerService answerService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody AnswerDTO r) {
        logger.info("AnswerController.save param: r is {}", r);
        int i = answerService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("AnswerController.delete param: id is {}", id);
        int i = answerService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("AnswerController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, answerService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody AnswerDTO r) {
        logger.info("AnswerController.update param: r is {}", r);
        int i = answerService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody AnswerSearchDTO r) {
        logger.info("AnswerController.list param: r is {}", r);
        List<AnswerVO> list = answerService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody AnswerSearchDTO r){
        logger.info("AnswerController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<AnswerVO> list = answerService.list(r);
        Page<AnswerVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}