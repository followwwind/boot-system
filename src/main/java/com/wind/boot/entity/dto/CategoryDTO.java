package com.wind.boot.entity.dto;

import com.wind.boot.config.persistence.BaseDTO;
import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 标签 model
 * @author wind
 * @date 2021/04/18 19:14:56
 * @version V1.0
 */
public class CategoryDTO extends BaseDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /** 名称*/
    @NotBlank(message = "name不能为空", groups = {Add.class})
    private String name;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}