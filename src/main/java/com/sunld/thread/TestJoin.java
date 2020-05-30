package com.sunld.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/28 14:26
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread p = Thread.currentThread();
        for(int i = 0; i < 10; i++) {
            Thread t = new Thread(new D(p), String.valueOf(i));
            t.start();
            p = t;
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ddd");
    }

    static class D implements Runnable{
        private Thread thread;
        public D(Thread thread) {
            this.thread = thread;
        }
        public void run() {
            try {
                thread.join();
            }catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " dd11d");
        }
    }
}
