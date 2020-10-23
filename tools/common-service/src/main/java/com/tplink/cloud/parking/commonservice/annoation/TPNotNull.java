package com.tplink.cloud.parking.commonservice.annoation;

import com.tplink.cloud.parking.commonservice.annoation.validate.TPNotNullValidator;
import com.tplink.cloud.parking.commonservice.response.ErrorCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义校验注解
 * 不能为null，否则直接返回ErrorCode
 *
 * @author liming
 * @since 2020-09-27
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TPNotNullValidator.class})
public @interface TPNotNull {

    ErrorCode errorCode() default ErrorCode.ERROR_INVALID_PARAMS;

    //默认错误消息
    String message() default "{javax.validation.constraints.NotBlank.message}";

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};

    //指定多个时使用
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        TPNotNull[] value();
    }

}
