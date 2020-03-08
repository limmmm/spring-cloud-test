package com.lim.test.http.result;

import io.swagger.annotations.ApiModel;

/**
 * 返回结果枚举类
 * @author lim
 * @date 2020/3/8
 */
@ApiModel(value = "返回结果枚举类")
public enum ResultEnum {

	SUCCESS(1000, "操作成功！"),
	PARAM_LOST(1001, "参数缺失！"),
	PARAM_ERROR(1002, "参数格式错误！"),
	PERMISSION_FORBIDDEN(1003, "无操作权限！"),
	PERMISSION_LOCK(1004, "数据锁定！"),
	SERVICE_ERROR(1005,"业务逻辑错误！")
    ;
	
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
}
