package com.sunld.thread.jmm;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/31 21:04
 */
public class FinalExample {
    int i;                         // 普通变量
    final int j;                   // final变量
    static FinalExample obj;
    public FinalExample(){         // 构造函数
        i = 1;                     // 普通变量赋值
        j = 2;                     // final变量赋值
    }
    public static void writer(){   // 写线程A执行
        obj = new FinalExample();
    }
    public static void reader(){   // 读线程B执行
        FinalExample object = obj; // 读对象引用
        int a = object.i;          // 读普通变量
        int b = object.j;          // 读final变量
    }
}
