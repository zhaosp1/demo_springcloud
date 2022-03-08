package com.example.utilservice.battle.secondary.thread.pool;


import com.example.utilservice.battle.basal.temp.Action;
import com.example.utilservice.battle.basal.temp.Temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：固定线程池
 * @date 2021/8/18 23:22
 */
public class FixedThreadPoolDemo {
  public static void main(String[] args) {
    ExecutorService executor=Executors.newFixedThreadPool(5);
    for(int i=0;i<2;i++){
      executor.execute(new Runnable() {
        @Override
        public void run() {
          Temp.excute(1, new Action() {
            @Override
            public void excute() {
              System.out.println("newFixedThreadPool线程池执行线程"+Thread.currentThread().getName());
            }
          });
        }
      });
    }
  }
}
