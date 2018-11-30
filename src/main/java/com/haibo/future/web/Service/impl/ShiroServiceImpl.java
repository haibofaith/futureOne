package com.haibo.future.web.Service.impl;

import com.haibo.future.web.Service.ShiroService;
import com.haibo.future.web.mappers.ShiroMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShiroServiceImpl implements ShiroService{
    @Resource
    private ShiroMapper shiroMapper;
    @Override
    public String selectPwdByUserName(String userName) {
        return shiroMapper.selectPwdByUserName(userName);
    }

    @Override
    public List<String> selectRoleByUserName(String userName) {
        return shiroMapper.selectRoleByUserName(userName);
    }
}
