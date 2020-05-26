package com.sunld.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/27 19:31
 */
public class CreateThreadByFuture {

    public static void main(String[] args) {

//      创建任务对象
        FutureTask<Integer> thread = new FutureTask<Integer>(() -> {
            System.out.println("FutureTask====");
            return 100;
        });

//      创建并且启动线程
        new Thread(thread).start();
        try {
            // 处理返回值信息
            System.out.println(thread.get() + "===============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
