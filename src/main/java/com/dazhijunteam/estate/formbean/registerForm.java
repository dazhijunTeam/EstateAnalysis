package com.dazhijunteam.estate.formbean;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class registerForm {
    @NotEmpty(message = "姓名必填")
    private String username;
    @NotEmpty(message = "密码必填")
    private String password;
    @NotEmpty(message = "确认密码必填")
    private String password1;
    @NotEmpty(message = "城市必填")
    private String city;
    @NotNull(message = "薪资必填")
    private Integer salary;
    @NotNull(message = "期待房屋价格必填")
    private Integer Hprice;
}
