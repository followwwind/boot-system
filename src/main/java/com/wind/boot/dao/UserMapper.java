package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.User;
import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.entity.dto.UserSearchDTO;

/**
 * 用户表 dao
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
@SqlMapper
public interface UserMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(User r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    UserVO findById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param username
     * @return
     */
    UserVO findByName(@Param("username") String username);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(User r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(User r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<UserVO> list(UserSearchDTO r);

}