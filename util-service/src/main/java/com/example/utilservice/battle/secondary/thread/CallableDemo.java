package com.example.utilservice.battle.secondary.thread;

import com.example.battle.basal.temp.Action;
import com.example.battle.basal.temp.Temp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：Callable形式创建有返回值的线程
 * @date 2021/8/18 22:58
 */
public class CallableDemo implements Callable<String> {
  @Override
  public String call() throws Exception {
    try {
      Temp.excute(5, new Action() {
        @Override
        public void excute() {
          System.out.print("Callable接口方式线程输出!\n");
        }
      });
    } catch (Exception e) {
      return "线程执行失败："+e.getMessage();
    }
    return "线程执行成功！";
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<String> ft=new FutureTask<>(new CallableDemo());
    new Thread(ft).start();
    System.out.println("线程执行状态："+ft.get());
  }
}
