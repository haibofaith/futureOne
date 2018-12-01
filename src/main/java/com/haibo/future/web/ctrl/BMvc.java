package com.haibo.future.web.ctrl;

import com.haibo.future.web.models.impl.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Validated
@Controller
@RequestMapping(value = "/b")
public class BMvc {

    @RequestMapping(value = "/helloKitty")
    @ResponseBody
    public String helloKitty(HttpServletRequest request) {
        return "kittyCat";
    }

    @RequestMapping("/more")
    public ModelAndView more(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws Exception {
        return new ModelAndView("more");
    }


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws Exception {
        return new ModelAndView("login");
    }


    @RequestMapping("/error")
    public ModelAndView error(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws Exception {
        return new ModelAndView("error");
    }
}
