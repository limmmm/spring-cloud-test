package com.lim.test.http.result;


/**
 * Http 返回结果封装
 * <p>Created by lxl on 2018-11-07</p>
 */
public class ResultVOUtil {

	/**
     * 操作成功，无业务返回参数
	 */
	public static <T> ResultVO<T> success() {
		return success(null);
	}

	/**
	 * 操作成功，有业务返回参数
	 */
	public static <T> ResultVO<T> success(T data) {
		ResultVO<T> resultVO = new ResultVO<>();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMsg(ResultEnum.SUCCESS.getMessage());
		resultVO.setShow(false);
		resultVO.setData(data);
		return resultVO;
	}

	/**
	 * 操作失败，通用返回结果
	 * @param show 是否显示提示信息
	 */
	public static <T> ResultVO<T> error(Boolean show) {
		return new ResultVO<T>(ResultEnum.SERVICE_ERROR.getCode(), ResultEnum.SERVICE_ERROR.getMessage(), show, null);
	}

	/**
	 * 操作失败，自定义提示消息
	 * @param message 提示消息
	 * @param show 是否显示提示信息
	 */
	public static <T> ResultVO<T> error(String message, Boolean show) {
		return new ResultVO<T>(ResultEnum.SERVICE_ERROR.getCode(), message, show, null);
	}

	/**
	 * 操作失败，自定义错误类型
	 * @param resultEnum 错误类型
	 * @param show 是否显示提示信息
	 */
	public static <T> ResultVO<T> error(ResultEnum resultEnum, Boolean show) {
		return new ResultVO<T>(resultEnum.getCode(), resultEnum.getMessage(), show, null);
	}

	/**
	 * 操作失败，自定义错误类型与提示消息
	 * @param resultEnum 错误类型
	 * @param message 提示消息
	 * @param show 是否显示提示信息
	 */
	public static <T> ResultVO<T> error(ResultEnum resultEnum, String message, Boolean show) {
		return new ResultVO<T>(resultEnum.getCode(), message, show, null);
	}
	
}
