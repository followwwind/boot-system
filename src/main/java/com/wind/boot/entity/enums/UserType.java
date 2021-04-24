package com.wind.boot.entity.enums;

import com.wind.boot.config.BaseEnum;

import java.util.Arrays;

/**
 * @Title: LoginType
 * @Package com.wind.business.entity.enums
 * @Description: 用户类型，1：超级管理员，2：管理员，3：普通用户
 * @author wind
 * @date 2018/10/29 19:04
 * @version V1.0
 */
public enum UserType implements BaseEnum {

    USER(3, "普通用户"),
    ADMIN(2, "管理员"),
    SUPER_ADMIN(1, "超级管理员"),
    ;

    UserType(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    private Integer code;

    private String value;


    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static UserType getLoginType(Integer code) {
        return Arrays.stream(values()).filter(ele -> ele.getCode().equals(code))
                .findFirst().map(v -> valueOf(v.name())).orElse(null);
    }

    @Override
    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }

}
