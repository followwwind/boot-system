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
import com.wind.boot.service.KnowRecordService;
import com.wind.boot.entity.po.KnowRecord;
import com.wind.boot.entity.vo.KnowRecordVO;
import com.wind.boot.entity.dto.KnowRecordDTO;
import com.wind.boot.entity.dto.KnowRecordSearchDTO;

/**
 * 知识点浏览 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/knowRecord")
public class KnowRecordController{
	
	private final Logger logger = LoggerFactory.getLogger(KnowRecordController.class);
	
    @Autowired
    private KnowRecordService knowRecordService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody KnowRecordDTO r) {
        logger.info("KnowRecordController.save param: r is {}", r);
        int i = knowRecordService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("KnowRecordController.delete param: id is {}", id);
        int i = knowRecordService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("KnowRecordController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, knowRecordService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody KnowRecordDTO r) {
        logger.info("KnowRecordController.update param: r is {}", r);
        int i = knowRecordService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody KnowRecordSearchDTO r) {
        logger.info("KnowRecordController.list param: r is {}", r);
        List<KnowRecordVO> list = knowRecordService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody KnowRecordSearchDTO r){
        logger.info("KnowRecordController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<KnowRecordVO> list = knowRecordService.list(r);
        Page<KnowRecordVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}