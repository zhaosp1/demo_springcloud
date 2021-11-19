package com.example.utilservice.battle.secondary.thread;

import com.example.battle.basal.temp.Action;
import com.example.battle.basal.temp.Temp;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：Runnbale接口形式创建线程
 * @date 2021/8/18 22:54
 */
public class RunnableDemo implements Runnable{
  @Override
  public void run() {
    Temp.excute(5, new Action() {
      @Override
      public void excute() {
        System.out.print("Runnable接口方式线程输出!\n");
      }
    });
  }


  public static void main(String[] args) {
    new Thread(new RunnableDemo()).start();
  }
}
