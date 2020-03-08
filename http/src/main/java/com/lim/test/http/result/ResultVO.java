package com.lim.test.http.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回结果结构封装
 * @author lim
 * @date 2020/3/8
 */
@Data
@ToString
@ApiModel(value = "返回结果结构封装")
@NoArgsConstructor
public class ResultVO<T> {

	@ApiModelProperty(value = "返回状态码")
	private Integer resultCode;

	@ApiModelProperty(value = "操作信息")
	private String resultMsg;

	@ApiModelProperty(value = "操作信息是否弹框提示")
	private Boolean show;

	@ApiModelProperty(value = "业务数据")
	private T data;

	public ResultVO(Integer resultCode, String resultMsg, Boolean show, T data) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.show = show;
		this.data = data;
	}
	
}
