package com.haibo.future.web.interview.Math;

public class MathTest {
    public static void main(String args[]) {
        double num = 3.5;
        System.out.println("大于" + num + "的最小数：" + Math.ceil(num));
        System.out.println("小于" + num + "的最大数：" + Math.floor(num));
        System.out.println(num + "四舍五入得到浮点数：" + Math.rint(num));
        System.out.println(num + "四舍五入得到长整数：" + Math.round(num));

        num = -3.6;
        System.out.println("大于" + num + "的最小数：" + Math.ceil(num));
        System.out.println("小于" + num + "的最大数：" + Math.floor(num));
        System.out.println(num + "四舍五入得到浮点数：" + Math.rint(num));
        System.out.println(num + "四舍五入得到长整数：" + Math.round(num));
    }
}
