package com.lim.test.http.annoation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验注解实现
 * @author Lim
 * @since 2019/4/22
 */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String>{

    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate(defaultConstraintMessageTemplate).addConstraintViolation();
            return false;
        }
        return true;
    }

}
