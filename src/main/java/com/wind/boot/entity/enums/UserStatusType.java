package com.wind.boot.entity.enums;

import com.wind.boot.config.BaseEnum;

import java.util.Arrays;

/**
 * @Title: LoginType
 * @Package com.wind.business.entity.enums
 * @Description: 状态，0：正常，1：禁止评论，2：禁止发表知识点，3：用户永久封号
 * @author wind
 * @date 2018/10/29 19:04
 * @version V1.0
 */
public enum UserStatusType implements BaseEnum {
    /**
     * 正常
     */
    NORMAL(0, "正常"),
    DISABLE_COMMENT(1, "禁止评论"),
    DISABLE_KNOW(2, "禁止发表知识点"),
    /**
     * 用户永久封号
     */
    DISABLED(3, "用户永久封号"),
    ;

    UserStatusType(Integer code, String value){
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

    public static UserStatusType getLoginType(Integer code) {
        return Arrays.stream(values()).filter(ele -> ele.getCode().equals(code))
                .findFirst().map(v -> valueOf(v.name())).orElse(null);
    }

    @Override
    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }

}
