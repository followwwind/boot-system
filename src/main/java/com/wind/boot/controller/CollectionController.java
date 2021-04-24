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
import com.wind.boot.service.CollectionService;
import com.wind.boot.entity.po.Collection;
import com.wind.boot.entity.vo.CollectionVO;
import com.wind.boot.entity.dto.CollectionDTO;
import com.wind.boot.entity.dto.CollectionSearchDTO;

/**
 * 知识点收藏表 controller
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/collection")
public class CollectionController{
	
	private final Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
    @Autowired
    private CollectionService collectionService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/")
    public JsonResult save(@RequestBody CollectionDTO r) {
        logger.info("CollectionController.save param: r is {}", r);
        int i = collectionService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("CollectionController.delete param: id is {}", id);
        int i = collectionService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("CollectionController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, collectionService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PutMapping("/")
    public JsonResult update(@RequestBody CollectionDTO r) {
        logger.info("CollectionController.update param: r is {}", r);
        int i = collectionService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody CollectionSearchDTO r) {
        logger.info("CollectionController.list param: r is {}", r);
        List<CollectionVO> list = collectionService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody CollectionSearchDTO r){
        logger.info("CollectionController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<CollectionVO> list = collectionService.list(r);
        Page<CollectionVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}