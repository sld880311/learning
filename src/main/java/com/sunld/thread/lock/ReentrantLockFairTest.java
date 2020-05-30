package com.sunld.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 公平锁测试
 * 公平锁一般没有必要，会降低并发度，后面分析原理时会讲解
 * @date : 2020/5/30 22:02
 */
public class ReentrantLockFairTest {

    public static void testFair(boolean fair){
        ReentrantLock lock = new ReentrantLock(fair);
        lock.lock();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " running...");
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }
        // 1s 之后去争抢锁
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start...");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " running...");
            } finally {
                lock.unlock();
            }
        }, "强行写入").start();
        lock.unlock();
    }

    public static void main(String[] args) {
        //公平
        ReentrantLockFairTest.testFair(true);
        //非公平
        ReentrantLockFairTest.testFair(false);
    }
}
