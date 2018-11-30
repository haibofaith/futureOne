package com.haibo.future.web.Service;

import com.haibo.future.web.datasource.DataSource;
import com.haibo.future.web.datasource.DataSourceConstant;

import java.util.List;

public interface ShiroService {
    @DataSource(DataSourceConstant.DATA_SOURCE_LOCAL)
    String selectPwdByUserName(String userName);

    @DataSource(DataSourceConstant.DATA_SOURCE_LOCAL)
    List<String> selectRoleByUserName(String userName);
}
