package com.haibo.future.web.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author:haibo.xiong
 * @date:2018/12/2
 * @description:
 */
public class RolesOrFilter extends AuthorizationFilter{
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse,
                                      Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[]) o;
        //无权限要求
        if (roles==null||roles.length==0){
            return true;
        }
        //多权限要求，有任何一个都返回true
        for (String role: roles){
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
