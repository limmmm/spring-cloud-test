package com.lim.test.http.handler;

import com.lim.test.http.exception.ServiceException;
import com.lim.test.http.result.ResultEnum;
import com.lim.test.http.result.ResultVO;
import com.lim.test.http.result.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.sound.midi.Track;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 全局异常捕获
 *
 * @author lim
 * @date 2020/3/8
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理参数绑定异常
	 */
	@ExceptionHandler(BindException.class)
	public ResultVO<?> bindExceptionHandler(BindException e) {
		String message = e.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
		log.error(String.format("【参数类型异常】%s", message), e);
		return ResultVOUtil.error(ResultEnum.PARAM_ERROR, message, false);
	}
	
	/**
	 * 处理参数校验异常
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResultVO<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
		String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(";"));
		log.error(String.format("【参数校验失败】%s", message), e);
		return ResultVOUtil.error(ResultEnum.PARAM_ERROR, message, true);
	}
	
	/**
	 * 处理业务异常(中断)
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.OK)
	public ResultVO<?> serviceExceptionHandler(ServiceException e) {
		log.error("【业务异常】{}", e.getResultVO());
		return e.getResultVO();
	}
	
	/**
	 * 处理所有未知的运行时异常
	 * 
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultVO<?> allUnknowExceptionHandler(Exception e) {
		log.error(String.format("【未知异常】%s", e.getMessage()), e);
		return ResultVOUtil.error(ResultEnum.SERVER_ERROR, true);
	}

}
