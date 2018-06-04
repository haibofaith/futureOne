package com.haibo.future.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloMvc {
    @RequestMapping(value = "/hello", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String hello() {
        return "你好";
    }
}
