package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 基于Thread实现线程的创建
 * @date : 2020/5/27 18:50
 */
public class CreateThreadByThread extends Thread{
    @Override
    public void run() {
        // 需要实现的业务
        System.out.println("CreateThreadByThread.run() by extends Thread");
    }
    public static void main(String[] args) {
        // 多态创建线程
        Thread o = new CreateThreadByThread();
        // 启动线程
        o.start();
    }
}
// CreateThreadByThread.run() by extends Thread