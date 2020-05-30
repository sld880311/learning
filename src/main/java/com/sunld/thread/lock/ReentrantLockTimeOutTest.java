package com.sunld.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 锁超时
 * @date : 2020/5/30 21:36
 */
public class ReentrantLockTimeOutTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void timeOut0(){
        Thread thread = new Thread(() -> {
            System.out.println(" thread start ...");
            if(!lock.tryLock()){
                System.out.println(" thread get lock by 0s failed ...");
                return;
            }
            try {
                System.out.println(" thread get lock success..");
            }finally {
                lock.unlock();
                System.out.println(" thread release lock success..");
            }
        },"子线程！！！");
        lock.lock();
        System.out.println(" main thread get lock success..");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(" main thread interrupted..");
        } finally {
            lock.unlock();
            System.out.println(" main thread release lock success..");
        }
    }

    public static void timeOut1(){
        Thread thread = new Thread(() -> {
            System.out.println(" thread start ...");
            try {
                if(!lock.tryLock(1, TimeUnit.SECONDS)){
                    System.out.println(" thread get lock by 1s failed ...");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(" thread get lock interrupted ....");
            }
            try {
                System.out.println(" thread get lock success..");
            }finally {
                lock.unlock();
                System.out.println(" thread release lock success..");
            }
        },"子线程！！！");
        lock.lock();
        System.out.println(" main thread get lock success..");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(" main thread interrupted..");
        } finally {
            lock.unlock();
            System.out.println(" main thread release lock success..");
        }
    }

    public static void main(String[] args) {
        ReentrantLockTimeOutTest.timeOut0();
//        ReentrantLockTimeOutTest.timeOut1();
    }
}
