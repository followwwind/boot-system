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
import com.wind.boot.service.CategoryService;
import com.wind.boot.entity.po.Category;
import com.wind.boot.entity.vo.CategoryVO;
import com.wind.boot.entity.dto.CategoryDTO;
import com.wind.boot.entity.dto.CategorySearchDTO;

/**
 * 标签 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/category")
public class CategoryController{
	
	private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
    @Autowired
    private CategoryService categoryService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody CategoryDTO r) {
        logger.info("CategoryController.save param: r is {}", r);
        int i = categoryService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("CategoryController.delete param: id is {}", id);
        int i = categoryService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("CategoryController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, categoryService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody CategoryDTO r) {
        logger.info("CategoryController.update param: r is {}", r);
        int i = categoryService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody CategorySearchDTO r) {
        logger.info("CategoryController.list param: r is {}", r);
        List<CategoryVO> list = categoryService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody CategorySearchDTO r){
        logger.info("CategoryController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<CategoryVO> list = categoryService.list(r);
        Page<CategoryVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}