package com.haibo.future.web.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.haibo.common.request.UserRequest;
import com.haibo.future.web.Service.TestService;
import com.haibo.future.web.entity.BaseResponse;
import com.haibo.future.web.entity.LoginRequest;
import com.haibo.future.web.entity.PageModel;
import com.haibo.future.web.entity.TestModel;
import com.haibo.future.web.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Validated
@Controller
@RequestMapping(value = "/test")
public class HelloMvc {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(@RequestBody UserRequest request) {
        String name = request.getName();
        String password = request.getPassword();
        return "hello:"+name+":"+password;
    }

    @Autowired
    private TestService testService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/hiSql")
    @ResponseBody
    public String hiSql(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        List<TestModel> testModels = testService.selectAll();
        PageModel<TestModel> pageModel  = new PageModel<>();
        pageModel.setList(testModels);
        response.setBody(pageModel);
        return response.toString();
    }


    @RequestMapping(value = "/hiRedis")
    @ResponseBody
    public String hiRedis(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        String str = redisTemplate.opsForValue().get("addr");
        if (str==null){
            redisTemplate.opsForValue().set("addr","beijing");
        }
        response.setBody(str);
        return response.toString();
    }



    @RequestMapping(value = "/hiSql2")
    @ResponseBody
    public String hiSql2(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();

        List<TestModel> testModels = testService.selectAll2();
        PageModel<TestModel> pageModel  = new PageModel<>();
        pageModel.setList(testModels);
        response.setBody(pageModel);

        return response.toString();
    }


    @RequestMapping(value = "/helloKitty")
    @ResponseBody
    public String helloKitty(HttpServletRequest request) {
        return "海波";
    }

    @RequestMapping(value = "/seckill")
    @ResponseBody
    public String seckill(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        int count = testService.updateProductNum();
        response.setBody(count);
        return response.toString();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody @Valid LoginRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "error:" + result.toString();
        } else {
            String name = request.getName();
            String password = request.getPassword();
            return "hello:" + name + ":" + password;
        }
    }

    @Autowired
    private Animal animal;
    @RequestMapping(value = "/aopAnimal")
    @ResponseBody
    private String aopAnimal(HttpServletRequest request){
        System.out.println("------------------");
        return animal.sayName("yellowBean",1);
    }

}
