package com.haibo.future.web.Service;

import com.haibo.future.web.entity.TestModel;

import java.util.List;

public interface TestService {
    List<TestModel> selectAll();
    //调用：每次减1
    int updateProductNum();
}
