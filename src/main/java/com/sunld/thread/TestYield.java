package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/28 8:45
 */
public class TestYield {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for(int i = 0; i < 1000; i++){
                System.out.println("----------->1---" + count++);
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for(int i = 0; i < 1000; i++){
                Thread.yield();
                System.out.println("----------->2---" + count++);
            }
        };

        Thread t1 = new Thread(task1, "thread1" );
        Thread t2 = new Thread(task2, "thread2" );
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
