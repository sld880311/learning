package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/29 14:01
 */
public class TestLiveLock {
    static volatile  int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while(count > 0){// 期望0时退出
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("11 count: " + count);
            }
        }).start();

        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("22 count: " + count);
            }

        }).start();
    }
}
