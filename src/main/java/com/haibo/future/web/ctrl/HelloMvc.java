package com.haibo.future.web.ctrl;

import com.haibo.common.request.UserRequest;
import com.haibo.future.web.Service.TestService;
import com.haibo.future.web.entity.BaseResponse;
import com.haibo.future.web.entity.PageModel;
import com.haibo.future.web.entity.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class HelloMvc {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(@RequestBody @Validated UserRequest request) {
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

    @RequestMapping(value = "/seckill")
    @ResponseBody
    public String seckill(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        int count = testService.updateProductNum();
        response.setBody(count);
        return response.toString();
    }






}
