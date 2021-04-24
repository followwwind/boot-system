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
import com.wind.boot.service.PaperService;
import com.wind.boot.entity.po.Paper;
import com.wind.boot.entity.vo.PaperVO;
import com.wind.boot.entity.dto.PaperDTO;
import com.wind.boot.entity.dto.PaperSearchDTO;

/**
 * 试卷 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/paper")
public class PaperController{
	
	private final Logger logger = LoggerFactory.getLogger(PaperController.class);
	
    @Autowired
    private PaperService paperService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody PaperDTO r) {
        logger.info("PaperController.save param: r is {}", r);
        int i = paperService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("PaperController.delete param: id is {}", id);
        int i = paperService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("PaperController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, paperService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody PaperDTO r) {
        logger.info("PaperController.update param: r is {}", r);
        int i = paperService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody PaperSearchDTO r) {
        logger.info("PaperController.list param: r is {}", r);
        List<PaperVO> list = paperService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody PaperSearchDTO r){
        logger.info("PaperController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<PaperVO> list = paperService.list(r);
        Page<PaperVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}