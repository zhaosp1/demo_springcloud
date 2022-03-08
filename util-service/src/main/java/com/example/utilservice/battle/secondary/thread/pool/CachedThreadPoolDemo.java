package com.example.utilservice.battle.secondary.thread.pool;

import com.example.utilservice.battle.basal.temp.Action;
import com.example.utilservice.battle.basal.temp.Temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：缓存线程池
 * @date 2021/8/18 23:30
 */
public class CachedThreadPoolDemo {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
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
