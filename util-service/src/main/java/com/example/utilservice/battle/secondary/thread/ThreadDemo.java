package com.example.utilservice.battle.secondary.thread;

import com.example.utilservice.battle.basal.temp.Action;
import com.example.utilservice.battle.basal.temp.Temp;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：Thread类形式创建线程
 * @date 2021/8/18 22:45
 */
public class ThreadDemo extends Thread{
  @Override
  public void run() {
    Temp.excute(5, new Action() {
      @Override
      public void excute() {
        System.out.print("Thread类方式线程输出!\n");
      }
    });

  }

  public static void main(String[] args) {
    ThreadDemo threadDemo=new ThreadDemo();
    threadDemo.start();
  }
}
