package com.wind.boot.config.validation.annotation;

import com.wind.boot.config.validation.validator.BlankOrPatternValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern.Flag;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Title: BlankOrPattern
 * @Package com.wind.boot.config.validation.annotation
 * @Description: 选填注解，不为空时必须满足正则表达式
 * @author wind
 * @date 2019/3/2 17:28
 * @version V1.0
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BlankOrPatternValidator.class)
public @interface BlankOrPattern {
    String regexp();
    Flag[] flags() default {};
    String message() default "{javax.validation.constraints.Pattern.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}