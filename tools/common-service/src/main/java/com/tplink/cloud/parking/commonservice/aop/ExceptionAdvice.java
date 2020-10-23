package com.tplink.cloud.parking.commonservice.aop;

import com.tplink.cloud.parking.commonservice.exception.ServiceException;
import com.tplink.cloud.parking.commonservice.response.ErrorCode;
import com.tplink.cloud.parking.commonservice.response.ResponseBody;
import com.tplink.cloud.parking.commonservice.response.ResponseBodyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * controller异常处理
 *
 * @author liming
 * @since 2020-09-27
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 处理业务异常(中断)
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<?> serviceExceptionHandler(ServiceException e) {
        log.error("【业务异常】{}", e.getResponseBody(), e);
        return e.getResponseBody();
    }

    /**
     * 处理参数校验异常
     * 返回第一条错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<?> constraintViolationExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        log.error("【参数校验失败】{}", allErrors, e);
        return ResponseBodyUtil.fail(ErrorCode.ERROR_INVALID_PARAMS, allErrors.get(0).getDefaultMessage());
    }

    /**
     * 参数校验异常处理
     * 返回第一条错误信息
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<?> constraintViolationExceptionHandler(BindException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        log.error("【参数校验失败】{}", allErrors, e);
        return ResponseBodyUtil.fail(ErrorCode.ERROR_INVALID_PARAMS, allErrors.get(0).getDefaultMessage());
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<?> unknownExHandler(Exception e) {
        // 如果因ServiceException导致的异常，仍按照ServiceException返回
        if (e.getCause() instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e.getCause();
            log.error("【业务异常】{}", serviceException.getResponseBody(), e);
            return serviceException.getResponseBody();
        }
        log.error("【未知错误】", e);
        return ResponseBodyUtil.fail(ErrorCode.ERROR_SERVER_INTERNAL_ERROR);
    }

}
