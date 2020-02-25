package com.lim.test.http.validate.module.dto;

import com.lim.test.http.validate.module.group.NameGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Lim
 * @date 2020/2/22
 */
@Data
public class UserDto {

	private int age;

	@NotBlank(groups = {NameGroup.class}, message = "name can not be null or blank")
	private String name;

	@NotBlank(message = "sex can not be null")
	private String sex;
}
