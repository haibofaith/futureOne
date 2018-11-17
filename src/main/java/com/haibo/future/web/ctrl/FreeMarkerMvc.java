package com.haibo.future.web.ctrl;

import com.haibo.future.web.models.impl.Person;
import com.haibo.future.web.models.impl.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class FreeMarkerMvc {


    @RequestMapping(value = "/hellofree")
    public ModelAndView helloFreemarker(HttpServletRequest request) throws ParseException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freemarker/hellofree");
//        mv.addObject("username","你好，Freemarker");
        List<User> people = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2017-11-18 12:30:15");
        people.add(new User("bobo",date));
        people.add(new User("hehe",new Date()));
        mv.addObject("userList",people);
        return mv;
    }
}
