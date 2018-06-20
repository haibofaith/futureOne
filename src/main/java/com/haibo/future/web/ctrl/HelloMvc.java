package com.haibo.future.web.ctrl;

import com.haibo.common.request.UserRequest;
import com.haibo.future.web.Service.TestService;
import com.haibo.future.web.entity.BaseResponse;
import com.haibo.future.web.entity.LoginRequest;
import com.haibo.future.web.entity.PageModel;
import com.haibo.future.web.entity.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

}
