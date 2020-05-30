package com.sunld.thread.lock;

/**
 * @author : sunliaodong
 * @version : V1.0.0
 * @description: TODO
 * @date : 2020/5/30 19:00
 */
public class TestSynchronized {
    
    public synchronized static void test1(){

    }

    public synchronized void test2(){

    }

    public void test3(){
        synchronized(this){

        }
    }

    public static void test4(){
        synchronized(TestSynchronized.class){

        }
    }

    public static void main(String[] args) {

    }
    
}
