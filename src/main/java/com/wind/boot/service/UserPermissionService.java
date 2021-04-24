package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.UserPermission;
import com.wind.boot.entity.vo.UserPermissionVO;
import com.wind.boot.entity.dto.UserPermissionDTO;
import com.wind.boot.entity.dto.UserPermissionSearchDTO;

/**
 * 管理员权限分配 service
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public interface UserPermissionService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(UserPermissionDTO r);

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
    UserPermissionVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(UserPermissionDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<UserPermissionVO> list(UserPermissionSearchDTO r);
}