package com.haibo.future.web.models.impl;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义指令
 */
@Repository
public class RoleDirectModel implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map map,
                        TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        TemplateScalarModel user = (TemplateScalarModel) map.get("user");
        TemplateScalarModel role = (TemplateScalarModel) map.get("role");
        if ("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())) {
            templateModels[0] = TemplateBooleanModel.TRUE;
        }
        List<String> otherRights = new ArrayList<>();
        otherRights.add("add");
        otherRights.add("delete");
        otherRights.add("update");
        templateModels[1] = new SimpleSequence(otherRights);

        templateDirectiveBody.render(environment.getOut());
    }
}
