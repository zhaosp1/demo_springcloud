package com.example.utilservice.util.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: zhaosp1
 * @description: 单例线程池：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * @version: 1.0
 * @createDate: 2021/09/21 8:49
 */
public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10000; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
