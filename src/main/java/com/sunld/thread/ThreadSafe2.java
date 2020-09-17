package com.sunld.thread;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/6/6 20:45
 */
public class ThreadSafe2 extends Thread{
    @Override
    public void run() {
        while (!isInterrupted()) { // 非阻塞过程中通过判断中断标志来退出
            try {
                Thread.sleep(5 * 1000);// 阻塞过程捕获中断异常来退出
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;// 捕获到异常之后，执行 break 跳出循环
            }
        }
    }
}
