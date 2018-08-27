package com.haibo.future.web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
@Component
@Aspect
//通知+切点 = 切面
public class CacheAspect {
    //一、定义切点
    @Pointcut("@annotation(Cache)")
    private void cache1(){

    }

    private static Map<String,Object> cacheList = new LinkedHashMap<>();
    //二、定义通知
    @Around("cache1()")
    private Object cacheAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获得目标对象
        Object object = proceedingJoinPoint.getTarget();
        //获得参数
        Object[] args = proceedingJoinPoint.getArgs();
        //获得类名
        String className = object.getClass().getName();
        //获得方法签名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获得方法
        Method method = methodSignature.getMethod();
        String cacheKey = className + "_"+method.getName()+"_"+ JSONObject.toJSONString(args);
        if (cacheList.containsKey(cacheKey)){
            Object result = cacheList.get(cacheKey);
            System.out.println("data get cache:"+JSONObject.toJSONString(result));
            return result;
        }else {
            //切点执行结果
            Object result = proceedingJoinPoint.proceed();
            System.out.println("data get db:"+JSONObject.toJSONString(result));
            cacheList.put(cacheKey,result);
            return result;
        }
    }

}
