package com.haibo.future.web.ctrl;

import com.haibo.future.web.models.impl.Person;
import com.haibo.future.web.models.impl.User;
import com.haibo.future.web.template.SortMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping(value = "/cp1")
    public ModelAndView cp1(HttpServletRequest request) throws ParseException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freemarker/cp1");
        //整数
        mv.addObject("intVar",100);
        //长整型
        mv.addObject("longVar",10000L);
        //string
        mv.addObject("stringVar","好坑");
        //double
        mv.addObject("doubleVar",0.2345D);
        //boolean
        mv.addObject("booleanVar",true);
        //日期
        mv.addObject("dateVar",new java.sql.Date(new Date().getTime()));
        //null
        mv.addObject("nullVar",null);
        //对象
        User user = new User("bobo",new Date());
        mv.addObject("user",user);
        //集合list
        List<User> people = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2017-11-18 12:30:15");
        people.add(new User("bobo",date));
        people.add(new User("hehe",new Date()));
        mv.addObject("userList",people);
        //集合Map
        Map<String,String> map = new HashMap<>();
        map.put("session","123456");
        map.put("cookie","DSXDE");
        map.put("isShow","true");
        mv.addObject("userMap",map);
        //
        List<String> mylist = new ArrayList<>();
        mylist.add("simayi");
        mylist.add("caocao");
        mv.addObject("mylist",mylist);
        //排序
        mv.addObject("sort_int", new SortMethod());
        return mv;
    }
}
