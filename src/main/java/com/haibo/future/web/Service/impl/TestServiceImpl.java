package com.haibo.future.web.Service.impl;

import com.haibo.future.web.Service.TestService;
import com.haibo.future.web.entity.TestModel;
import com.haibo.future.web.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<TestModel> selectAll() {
        return testMapper.selectMyTest();
    }
}
