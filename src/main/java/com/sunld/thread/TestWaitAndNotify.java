package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/28 20:59
 */
public class TestWaitAndNotify {
    final static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("1: 执行....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1: 其它代码....");
            }
        }).start();
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("2: 执行....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2: 其它代码....");
            }
        }).start();
        // 主线程两秒后执行
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("唤醒 obj 上其它线程");
        synchronized (obj) {
//            obj.notify(); // 唤醒obj上一个线程
             obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
    /**
     notify:
     1: 执行....
     2: 执行....
     唤醒 obj 上其它线程
     1: 其它代码....
     */
    
    /**
     notifyal
     1: 执行....
     2: 执行....
     唤醒 obj 上其它线程
     2: 其它代码....
     1: 其它代码....
     */
}
