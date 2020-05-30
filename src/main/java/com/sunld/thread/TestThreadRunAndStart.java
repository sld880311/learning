package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 测试run方法和start方法的区别
 * @date : 2020/5/27 20:19
 */
public class TestThreadRunAndStart {

    public static void  testRun(Thread t1){
        t1.run();
        System.out.println("do other things ...");
    }

    public static void  testStart(Thread t1){
        t1.start();
        System.out.println("do other things ...");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "end");
            }
        };
        //顺序执行
//        TestThreadRunAndStart.testRun(t1);
        //异步执行
        TestThreadRunAndStart.testStart(t1);
    }
}
