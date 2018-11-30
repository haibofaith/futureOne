package com.haibo.future.web.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiroMapper {
    String selectPwdByUserName(@Param("userName") String userName);

    List<String> selectRoleByUserName(@Param("userName") String userName);
}
