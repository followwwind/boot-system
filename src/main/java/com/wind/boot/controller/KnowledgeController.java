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
import com.wind.boot.service.KnowledgeService;
import com.wind.boot.entity.po.Knowledge;
import com.wind.boot.entity.vo.KnowledgeVO;
import com.wind.boot.entity.dto.KnowledgeDTO;
import com.wind.boot.entity.dto.KnowledgeSearchDTO;

/**
 * 知识点 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/knowledge")
public class KnowledgeController{
	
	private final Logger logger = LoggerFactory.getLogger(KnowledgeController.class);
	
    @Autowired
    private KnowledgeService knowledgeService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody KnowledgeDTO r) {
        logger.info("KnowledgeController.save param: r is {}", r);
        int i = knowledgeService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("KnowledgeController.delete param: id is {}", id);
        int i = knowledgeService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("KnowledgeController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, knowledgeService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody KnowledgeDTO r) {
        logger.info("KnowledgeController.update param: r is {}", r);
        int i = knowledgeService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody KnowledgeSearchDTO r) {
        logger.info("KnowledgeController.list param: r is {}", r);
        List<KnowledgeVO> list = knowledgeService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody KnowledgeSearchDTO r){
        logger.info("KnowledgeController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<KnowledgeVO> list = knowledgeService.list(r);
        Page<KnowledgeVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}