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
import com.wind.boot.service.PaperRecordService;
import com.wind.boot.entity.po.PaperRecord;
import com.wind.boot.entity.vo.PaperRecordVO;
import com.wind.boot.entity.dto.PaperRecordDTO;
import com.wind.boot.entity.dto.PaperRecordSearchDTO;

/**
 * 试卷小测记录 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/paperRecord")
public class PaperRecordController{
	
	private final Logger logger = LoggerFactory.getLogger(PaperRecordController.class);
	
    @Autowired
    private PaperRecordService paperRecordService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody PaperRecordDTO r) {
        logger.info("PaperRecordController.save param: r is {}", r);
        int i = paperRecordService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("PaperRecordController.delete param: id is {}", id);
        int i = paperRecordService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("PaperRecordController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, paperRecordService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody PaperRecordDTO r) {
        logger.info("PaperRecordController.update param: r is {}", r);
        int i = paperRecordService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody PaperRecordSearchDTO r) {
        logger.info("PaperRecordController.list param: r is {}", r);
        List<PaperRecordVO> list = paperRecordService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody PaperRecordSearchDTO r){
        logger.info("PaperRecordController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<PaperRecordVO> list = paperRecordService.list(r);
        Page<PaperRecordVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}