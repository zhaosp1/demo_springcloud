package com.example.utilservice.util.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaosp1
 * @description: 缓存线程池：创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * @version: 1.0
 * @createDate: 2021/09/21 8:23
 */
public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                System.out.println("普通方法执行："+index);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("缓存线程池执行："+index);
                }
            });
        }
    }
}
