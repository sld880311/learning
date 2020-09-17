package com.sunld.thread.jmm;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: 不适用Volatile导致的死循环
 * 不同的CPU可能无法达到演示效果
 * @date : 2020/5/31 16:05
 */
public class VolatileDeadCircleTest {
    private volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileDeadCircleTest t = new VolatileDeadCircleTest();
        AtomicInteger count = new AtomicInteger();
        new Thread(() -> {
            while(t.isRun()){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程一致执行:" + (count.getAndIncrement()));
            }
        }).start();
        sleep(10 * 1000L);
        // 计划停止子线程，但是和预期可能不一致，最终会停止
        t.setRun(false);
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
