package com.sunld.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/30 22:08
 */
public class ReentrantLockConditionTest {
    private static final Lock lock = new ReentrantLock();
    //Lock lock=new ReentrantLock(true);//公平锁
    //Lock lock=new ReentrantLock(false);//非公平锁
    private static final Condition condition = lock.newCondition();//创建 Condition

    public static void testWait() {
        lock.lock();//lock 加锁
        try {
            //1：wait 方法等待：
            System.out.println("开始 wait");
            condition.await();
            //通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()+ (" " + (i + 1)));
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("释放锁");
        }
    }

    public static void testNotify() {
        lock.lock();//lock 加锁
        try {
            //1：开始唤醒：
            System.out.println("开始 signal");
            //2：signal 方法唤醒
            //condition 对象的 signal 方法可以唤醒 wait 线程
            condition.signalAll();
        }finally {
            lock.unlock();
            System.out.println("唤醒释放锁");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            ReentrantLockConditionTest.testWait();
        }, "等待通知").start();

        new Thread(() -> {
            ReentrantLockConditionTest.testNotify();
        },"启动通知").start();
    }
}
/**
 * TODO:
 * 开始 wait
 * 开始 signal
 * 唤醒释放锁
 * ThreadName=等待通知 1
 * ThreadName=等待通知 2
 * ThreadName=等待通知 3
 * ThreadName=等待通知 4
 * ThreadName=等待通知 5
 * 释放锁
 */