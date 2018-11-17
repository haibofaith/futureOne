package com.haibo.future.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class FreeMarkerMvc {
    @RequestMapping(value = "/hellofree")
    public ModelAndView helloFreemarker(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freemarker/hellofree");
        mv.addObject("username","你好，Freemarker");
        return mv;
    }
}
