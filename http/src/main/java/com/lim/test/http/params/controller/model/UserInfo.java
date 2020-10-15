package com.lim.test.http.params.controller.model;

import lombok.Data;

/**
 * 用户信息
 * @author Li Ming
 * @date 2020/7/16
 */
@Data
public class UserInfo {

	/** id */
	private Long userId;

	/** 用户名 */
	private String userName;

	/** 中文名 */
	private String chineseName;

}
