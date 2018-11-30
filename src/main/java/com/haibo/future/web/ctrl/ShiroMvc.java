package com.haibo.future.web.ctrl;

import com.haibo.future.web.models.impl.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/shiro")
public class ShiroMvc {

    @RequestMapping(value = "/sublogin",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String sublogin(UserInfo request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(),request.getPassword());
        try {
            subject.login(token);
        }catch (Exception e){
            return e.getMessage();
        }
        if (subject.hasRole("admin")){
            return "管理员登录成功";
        }else if (subject.hasRole("guest")){
            return "游客登录成功";
        }
        return "登录成功";
    }

}
