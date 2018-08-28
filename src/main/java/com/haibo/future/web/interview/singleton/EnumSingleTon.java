package com.haibo.future.web.interview.singleton;

/**
 * 枚举：属于常量类，一经定义，不许修改，本身不允许public构造方法
 */
enum EnumSingleTon {
    SINGLE_TON;
    private EnumSingleTon(){}
}
