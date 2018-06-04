package com.haibo.future.web.ctrl;

import com.haibo.common.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloMvc {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(@RequestBody UserRequest request) {
        String name = request.getName();
        String password = request.getPassword();
        return "hello:"+name+":"+password;
    }
}
