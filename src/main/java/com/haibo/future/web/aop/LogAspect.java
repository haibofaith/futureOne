package com.haibo.future.web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(public * *sayName(..))")
    private void Cache2(){}

    //定义环绕通知：处理日志注入
    @Around("Cache2()")
    private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("before, params:" + JSONObject.toJSONString(args));
        Object result = proceedingJoinPoint.proceed();
        System.out.println("after, result:" + JSONObject.toJSONString(result));
        return result;
    }
}
