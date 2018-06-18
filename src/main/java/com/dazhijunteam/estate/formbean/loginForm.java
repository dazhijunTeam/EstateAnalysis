package com.dazhijunteam.estate.formbean;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class loginForm {
    @NotEmpty(message = "姓名必填")
    private String username;
    @NotEmpty(message = "密码必填")
    private String password;
}
