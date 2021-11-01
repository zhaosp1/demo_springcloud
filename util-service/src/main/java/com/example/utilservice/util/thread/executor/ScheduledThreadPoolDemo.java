package com.example.utilservice.util.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhaosp1
 * @description: 定时线程池：创建一个定长线程池，支持定时及周期性任务执行。
 * @version: 1.0
 * @createDate: 2021/09/21 8:38
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时线程池执行，延时3秒执行");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds(延时一秒，每三秒执行一次）");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
