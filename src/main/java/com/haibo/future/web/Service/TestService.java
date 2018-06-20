package com.haibo.future.web.Service;

import com.haibo.future.web.datasource.DataSource;
import com.haibo.future.web.datasource.DataSourceConstant;
import com.haibo.future.web.entity.TestModel;

import java.util.List;

public interface TestService {
    @DataSource(DataSourceConstant.DATA_SOURCE_EBK)
    List<TestModel> selectAll();
    //调用：每次减1
    @DataSource(DataSourceConstant.DATA_SOURCE_CRM)
    List<TestModel> selectAll2();

    int updateProductNum();
}
