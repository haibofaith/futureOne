package com.haibo.future.web.entity;

import com.haibo.future.web.validators.PwdValidator;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class LoginRequest implements Serializable {
    @NotBlank(message="名字不能为空")
    private String name;
    @PwdValidator(message = "密码不符合规则")
    private String password;

    public LoginRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
