package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 通过Runnable创建线程，实现业务与线程的解耦
 * @date : 2020/5/27 18:55
 */
public class CreateThreadByRunnable implements Runnable{
    @Override
    public void run() {
        // 实际执行的业务
        System.out.println("====CreateThreadByRunnable=====Runnable====");
    }
    public static void main(String[] args) {
        // 实例化线程
        Thread t = new Thread(new CreateThreadByRunnable());
        // 启动线程
        t.start();

        // JDK1.8之后的实现
        Runnable task2 = () -> System.out.println("task2 jdk8");
        new Thread(task2, "task2").start();
    }
}
//====CreateThreadByRunnable=====Runnable====
//task2 jdk8