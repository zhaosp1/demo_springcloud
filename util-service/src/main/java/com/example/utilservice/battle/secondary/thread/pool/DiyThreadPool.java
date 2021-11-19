package com.example.utilservice.battle.secondary.thread.pool;

import java.util.LinkedList;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：自定义线程池
 * @date 2021/8/18 23:34
 */
public class DiyThreadPool {
  // 线程池大小
  int threadPoolSize;

  // 任务容器
  LinkedList<Runnable> tasks = new LinkedList<Runnable>();

  // 试图消费任务的线程

  public DiyThreadPool() {
    threadPoolSize = 10;

    // 启动10个任务消费者线程
    synchronized (tasks) {
      for (int i = 0; i < threadPoolSize; i++) {
        new TaskConsumeThread("任务消费者线程 " + i).start();
      }
    }
  }

  public void add(Runnable r) {
    synchronized (tasks) {
      tasks.add(r);
      // 唤醒等待的任务消费者线程
      tasks.notifyAll();
    }
  }

  class TaskConsumeThread extends Thread {
    public TaskConsumeThread(String name) {
      super(name);
    }

    Runnable task;

    public void run() {
      System.out.println("启动： " + this.getName());
      while (true) {
        synchronized (tasks) {
          while (tasks.isEmpty()) {
            try {
              tasks.wait();
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
          task = tasks.removeLast();
          // 允许添加任务的线程可以继续添加任务
          tasks.notifyAll();

        }
        System.out.println(this.getName() + " 获取到任务，并执行");
        task.run();
      }
    }
  }

  public static void main(String[] args) {
    DiyThreadPool pool= new DiyThreadPool();
    int sleep=1000;
    while(true){
      pool.add(new Runnable(){
        @Override
        public void run() {
          //System.out.println("执行任务");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      });
      try {
        Thread.sleep(sleep);
        sleep = sleep>100?sleep-100:sleep;
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
  }
}
