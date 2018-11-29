package com.haibo.future.web.template;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * freemarker的模版方法
 */
public class SortMethod implements TemplateMethodModelEx{
    @Override
    public Object exec(List list) throws TemplateModelException {
        //list --->SimpleSequence
        SimpleSequence sequence = (SimpleSequence) list.get(0);
        List<BigDecimal> list1=sequence.toList();
        Collections.sort(list1, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.intValue()-o2.intValue();//升序
            }
        });
        return list1;
    }
}
