package com.haibo.future.web.validators;

import com.haibo.common.request.UserRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TestValidators implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRequest userRequest = (UserRequest) o;
        if (StringUtils.isEmpty(userRequest.getPassword())){
            errors.rejectValue("password",null,null,"password is null");
        }
    }
}
