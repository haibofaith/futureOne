package com.haibo.future.web.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiroMapper {
    String selectPwdByUserName(@Param("userName") String userName);
}
