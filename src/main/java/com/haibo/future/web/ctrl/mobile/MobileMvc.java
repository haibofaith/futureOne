package com.haibo.future.web.ctrl.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Validated
@Controller
@RequestMapping(value = "/mobile")
public class MobileMvc {

    @RequestMapping(value = "/helloKitty")
    @ResponseBody
    public String helloKitty(HttpServletRequest request) {

        return "海波";
    }


}
