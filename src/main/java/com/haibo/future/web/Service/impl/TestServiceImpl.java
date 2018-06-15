package com.haibo.future.web.Service.impl;

import com.haibo.future.web.Service.TestService;
import com.haibo.future.web.entity.TestModel;
import com.haibo.future.web.mappers.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {
    static final Logger  logger= LoggerFactory.getLogger("commonSchedulerLogger");
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<TestModel> selectAll() {
        logger.info("查询结果是"+testMapper.selectMyTest().toString());
        return testMapper.selectMyTest();
    }

    @Override
    public int updateProductNum() {
        int count = testMapper.updateProductNum();
        logger.info("库存减少"+count+"条");
        return count;
    }
}
