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
import com.wind.boot.service.PaperIssueService;
import com.wind.boot.entity.po.PaperIssue;
import com.wind.boot.entity.vo.PaperIssueVO;
import com.wind.boot.entity.dto.PaperIssueDTO;
import com.wind.boot.entity.dto.PaperIssueSearchDTO;

/**
 * 试卷问题表 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/paperIssue")
public class PaperIssueController{
	
	private final Logger logger = LoggerFactory.getLogger(PaperIssueController.class);
	
    @Autowired
    private PaperIssueService paperIssueService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody PaperIssueDTO r) {
        logger.info("PaperIssueController.save param: r is {}", r);
        int i = paperIssueService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("PaperIssueController.delete param: id is {}", id);
        int i = paperIssueService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("PaperIssueController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, paperIssueService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody PaperIssueDTO r) {
        logger.info("PaperIssueController.update param: r is {}", r);
        int i = paperIssueService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody PaperIssueSearchDTO r) {
        logger.info("PaperIssueController.list param: r is {}", r);
        List<PaperIssueVO> list = paperIssueService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody PaperIssueSearchDTO r){
        logger.info("PaperIssueController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<PaperIssueVO> list = paperIssueService.list(r);
        Page<PaperIssueVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}