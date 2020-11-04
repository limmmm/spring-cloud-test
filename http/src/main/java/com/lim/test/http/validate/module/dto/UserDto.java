package com.lim.test.http.validate.module.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lim.test.http.validate.module.group.NameGroup;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lim
 * @since 2020/2/22
 */
@Data
public class UserDto {

    private int age;

    @NotBlank(groups = {NameGroup.class}, message = "name can not be null or blank")
    private String name;

    @NotBlank(message = "sex can not be null")
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate localDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime localDateTime;

}
