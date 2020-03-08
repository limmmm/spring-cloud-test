package com.lim.test.http.exception;


import com.lim.test.http.result.ResultVO;

/**
 * 自定义业务异常类
 * 
 * @author lim
 * @date 2020/3/8
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ResultVO resultVO;

	public ServiceException(ResultVO resultVO) {
		super(resultVO.toString());
		this.resultVO = resultVO;
	}

	public ResultVO getResultVO() {
		return resultVO;
	}
}
