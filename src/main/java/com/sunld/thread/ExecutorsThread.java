package com.sunld.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int taskSize = 10;
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建有返回值的任务
		List<Future<String>> list = new ArrayList<>();
		for(int i = 0; i < taskSize; i++) {
			list.add(pool.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "ddd:111  " + Thread.currentThread().getName();
				}
			}));
		}
		//关闭线程池
		pool.shutdown();
		// 获取结果
		for(Future<String> f : list) {
			System.out.println(f.get());
		}
	}
}
