package com.sunld.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 可中断测试
 * @date : 2020/5/30 20:54
 */
public class ReentrantLockInterruptedTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void testInterruptedEnable(){
        Thread thread = new Thread(() -> {
            System.out.println("testInterruptedEnable:子线程开始：。。。");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("testInterruptedEnable:子线程等待锁的过程被中断");
            }
            try{
                System.out.println("testInterruptedEnable:子线程获得了锁。。");
            }finally {
                lock.unlock();
            }
        },"可中断线程！！");

        lock.lock();
        System.out.println("testInterruptedEnable:主线程获得了锁。。");
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("testInterruptedEnable:子线程thread开始中断。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("testInterruptedEnable:主线程等待锁的过程被中断");
        } finally {
            lock.unlock();
        }
    }

    public static void testInterruptedUnable(){
        Thread thread = new Thread(() -> {
            System.out.println("testInterruptedEnable:子线程开始：。。。");
            lock.lock();

            try{
                System.out.println("testInterruptedEnable:子线程获得了锁。。");
            }finally {
                lock.unlock();
            }
        },"可中断线程！！");

        lock.lock();
        System.out.println("testInterruptedEnable:主线程获得了锁。。");
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("testInterruptedEnable:子线程thread开始中断。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("testInterruptedEnable:主线程等待锁的过程被中断");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockInterruptedTest.testInterruptedEnable();
//        ReentrantLockInterruptedTest.testInterruptedUnable();
    }
}
