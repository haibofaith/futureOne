package com.haibo.future.web.ctrl;

import com.haibo.future.web.models.impl.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequiresRoles("admin")
    @RequestMapping(value = "/testRole")
    @ResponseBody
    public String testRole(){
        return "admin success";
    }


    @RequiresRoles("guest")
    @RequestMapping(value = "/guestRole")
    @ResponseBody
    public String guestRole(){
        return "guest success";
    }


    @RequestMapping(value = "/getPerms")
    @ResponseBody
    public String getPerms(){
        return "adgetPerms success";
    }

    @RequestMapping(value = "/getPerms1")
    @ResponseBody
    public String getPerms1(){
        return "getPerms1 success";
    }

    @RequestMapping(value = "/getPerms2")
    @ResponseBody
    public String getPerms2(){
        return "getPerms2 success";
    }
}
