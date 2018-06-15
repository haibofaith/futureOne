package com.haibo.future.web.mappers;

import com.haibo.future.web.entity.TestModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestMapper {
    List<TestModel> selectMyTest();
    int updateProductNum();
}
