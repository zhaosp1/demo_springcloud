package com.example.utilservice.battle.secondary.thread.pool;

import com.example.battle.basal.temp.Action;
import com.example.battle.basal.temp.Temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：单线程池
 * @date 2021/8/18 23:28
 */
public class SingleThreadExecutorDemo {
  public static void main(String[] args) {
    ExecutorService executor= Executors.newSingleThreadExecutor();
    executor.execute(new Runnable() {
      @Override
      public void run() {
        Temp.excute(1, new Action() {
          @Override
          public void excute() {
            System.out.println("newSingleThreadExecutor线程池执行线程"+Thread.currentThread().getName());
          }
        });
      }
    });
  }
}
