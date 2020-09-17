package com.sunld.thread.jmm;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/6/3 17:34
 */
public class MonitorExample {
    int a = 0;

    public synchronized void writer(){ //1
        a++;                           //2
    }
                                       //3
    public synchronized void reader(){ //4
        System.out.println(a);         //5
    }
                                       //6
}
