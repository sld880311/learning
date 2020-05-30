package com.sunld.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description:
 * 可重入是指同一个线程如果首次获得了这把锁，那么因为它是这把锁的拥有者，因此有权利再次获取这把锁
 * 如果是不可重入锁，那么第二次获得锁时，自己也会被锁挡住
 * @date : 2020/5/30 20:41
 */
public class ReentrantLockReentryTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void test1(){
        lock.lock();
        try {
            System.out.println("test1----");
            test2();
        }finally {
            lock.unlock();
        }
    }

    private static void test2() {
        lock.lock();
        try {
            System.out.println("test2----");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockReentryTest.test1();
    }
}
