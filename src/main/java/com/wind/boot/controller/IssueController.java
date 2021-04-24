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
import com.wind.boot.service.IssueService;
import com.wind.boot.entity.po.Issue;
import com.wind.boot.entity.vo.IssueVO;
import com.wind.boot.entity.dto.IssueDTO;
import com.wind.boot.entity.dto.IssueSearchDTO;

/**
 * 题目 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/issue")
public class IssueController{
	
	private final Logger logger = LoggerFactory.getLogger(IssueController.class);
	
    @Autowired
    private IssueService issueService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody IssueDTO r) {
        logger.info("IssueController.save param: r is {}", r);
        int i = issueService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("IssueController.delete param: id is {}", id);
        int i = issueService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("IssueController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, issueService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody IssueDTO r) {
        logger.info("IssueController.update param: r is {}", r);
        int i = issueService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody IssueSearchDTO r) {
        logger.info("IssueController.list param: r is {}", r);
        List<IssueVO> list = issueService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody IssueSearchDTO r){
        logger.info("IssueController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<IssueVO> list = issueService.list(r);
        Page<IssueVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}