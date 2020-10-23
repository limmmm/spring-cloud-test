package com.tplink.cloud.parking.commonservice.annoation.validate;

import com.tplink.cloud.parking.commonservice.annoation.TPNotNull;
import com.tplink.cloud.parking.commonservice.response.ErrorCode;
import com.tplink.cloud.parking.commonservice.response.ResponseAssert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验注解
 * 不能为null，否则直接返回ErrorCode
 *
 * @author liming
 * @since 2020-09-27
 */
public class TPNotNullValidator implements ConstraintValidator<TPNotNull, Object>{

    private ErrorCode errorCode = ErrorCode.ERROR_INVALID_PARAMS;

    @Override
    public void initialize(TPNotNull constraintAnnotation) {
        errorCode = constraintAnnotation.errorCode();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            ResponseAssert.fail(errorCode);
        }
        return true;
    }

}
