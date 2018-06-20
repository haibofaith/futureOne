package com.haibo.future.web.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD,PARAMETER,FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PwdValidatorImpl.class})
public @interface PwdValidator {
    //默认错误消息
    String message() default "不能包含空格";

    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };
}
