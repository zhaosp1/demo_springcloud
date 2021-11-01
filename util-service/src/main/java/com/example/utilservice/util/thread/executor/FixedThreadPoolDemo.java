package com.example.utilservice.util.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaosp1
 * @description: 定长线程池：创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * @version: 1.0
 * @createDate: 2021/09/21 8:36
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                System.out.println("普通方法执行："+index);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("固定线程池执行："+index);
                }
            });
        }
    }
}
