package com.tplink.cloud.parking.commonservice.annoation.validate;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tplink.cloud.parking.commonservice.annoation.TPNotBlank;
import com.tplink.cloud.parking.commonservice.response.ErrorCode;
import com.tplink.cloud.parking.commonservice.response.ResponseAssert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验注解
 * 不能为null或空，否则直接返回ErrorCode
 *
 * @author liming
 * @since 2020-09-27
 */
public class TPNotBlankValidator implements ConstraintValidator<TPNotBlank, String>{

    private ErrorCode errorCode = ErrorCode.ERROR_INVALID_PARAMS;

    @Override
    public void initialize(TPNotBlank constraintAnnotation) {
        errorCode = constraintAnnotation.errorCode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value.trim())) {
            ResponseAssert.fail(errorCode);
        }
        return true;
    }

}
