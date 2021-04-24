package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.KnowComment;
import com.wind.boot.entity.vo.KnowCommentVO;
import com.wind.boot.entity.dto.KnowCommentDTO;
import com.wind.boot.entity.dto.KnowCommentSearchDTO;

/**
 * 知识点评论表 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface KnowCommentService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(KnowCommentDTO r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    KnowCommentVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(KnowCommentDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<KnowCommentVO> list(KnowCommentSearchDTO r);
}