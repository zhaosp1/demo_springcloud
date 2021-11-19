package com.example.utilservice.battle.secondary.thread.pool;

import com.example.battle.basal.temp.Action;
import com.example.battle.basal.temp.Temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：定时调度线程池
 * @date 2021/8/18 23:31
 */
public class ScheduledThreadPoolDemo {
  public static void main(String[] args) {
    ExecutorService executor= Executors.newScheduledThreadPool(2);
    for (int i = 0; i < 2; i++) {
      executor.execute(new Runnable() {
        @Override
        public void run() {
          Temp.excute(1, new Action() {
            @Override
            public void excute() {
              System.out.println("newCachedThreadPool线程池执行线程" + Thread.currentThread().getName());
            }
          });
        }
      });
    }
  }
}
