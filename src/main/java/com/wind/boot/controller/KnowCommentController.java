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
import com.wind.boot.service.KnowCommentService;
import com.wind.boot.entity.po.KnowComment;
import com.wind.boot.entity.vo.KnowCommentVO;
import com.wind.boot.entity.dto.KnowCommentDTO;
import com.wind.boot.entity.dto.KnowCommentSearchDTO;

/**
 * 知识点评论表 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/knowComment")
public class KnowCommentController{
	
	private final Logger logger = LoggerFactory.getLogger(KnowCommentController.class);
	
    @Autowired
    private KnowCommentService knowCommentService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody KnowCommentDTO r) {
        logger.info("KnowCommentController.save param: r is {}", r);
        int i = knowCommentService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("KnowCommentController.delete param: id is {}", id);
        int i = knowCommentService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("KnowCommentController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, knowCommentService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody KnowCommentDTO r) {
        logger.info("KnowCommentController.update param: r is {}", r);
        int i = knowCommentService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody KnowCommentSearchDTO r) {
        logger.info("KnowCommentController.list param: r is {}", r);
        List<KnowCommentVO> list = knowCommentService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody KnowCommentSearchDTO r){
        logger.info("KnowCommentController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<KnowCommentVO> list = knowCommentService.list(r);
        Page<KnowCommentVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}