package com.haibo.future.web.shiro.realm;

import com.haibo.future.web.Service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm{
    {
        super.setName("CustomRealm");
    }


    @Autowired
    private ShiroService shiroService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.从主体获取用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //2.通过用户名获取role
        List<String> roles = getRoleByUserName(userName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> role_sets = new HashSet<>(roles);
        authorizationInfo.setRoles(role_sets);
        return authorizationInfo;
    }

    private List<String> getRoleByUserName(String userName) {
        return shiroService.selectRoleByUserName(userName);
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        //2.通过用户名获取凭证
        String passWord = getPasswordByUserName(userName);
        if (passWord==null){
            return null;
        }else {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,passWord,"CustomRealm");
            return authenticationInfo;
        }
    }


    private String getPasswordByUserName(String userName) {
        return shiroService.selectPwdByUserName(userName);
    }

    public static void main(String[] args){
        //密文
        Md5Hash md5Hash = new Md5Hash("000000");
        System.out.println(md5Hash.toString());
    }
}
