package com.haibo.future.web.Service;

import com.haibo.future.web.datasource.DataSource;
import com.haibo.future.web.datasource.DataSourceConstant;

public interface ShiroService {
    @DataSource(DataSourceConstant.DATA_SOURCE_LOCAL)
    String selectPwdByUserName(String userName);
}
