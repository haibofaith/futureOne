package com.haibo.future.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PwdValidatorImpl implements ConstraintValidator<PwdValidator,String> {
    String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
    private Pattern pwdPattern = Pattern.compile(regStr);


    @Override
    public void initialize(PwdValidator pwdValidator) {
        System.out.println("--------------");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return pwdPattern.matcher(s.trim().toString()).matches();
    }
}
