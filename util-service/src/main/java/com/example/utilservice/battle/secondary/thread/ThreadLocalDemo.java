package com.example.utilservice.battle.secondary.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：ThreadLocal类型变量的使用
 * @date 2021/8/18 23:51
 */
public class ThreadLocalDemo {
  // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
  private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
    public Integer initialValue() {
      return 0;
    }
  };

  // ②获取下一个序列值
  public int getNextNum() {
    seqNum.set(seqNum.get() + 1);
    return seqNum.get();
  }

  public static void main(String[] args) {
    ThreadLocalDemo sn = new ThreadLocalDemo();
    // ③ 3个线程共享sn，各自产生序列号
    TestClient t1 = new TestClient(sn);
    TestClient t2 = new TestClient(sn);
    TestClient t3 = new TestClient(sn);
    t1.start();
    t2.start();
    t3.start();
    System.out.println(t1.getThreadLocalDemoNextNum());;
  }

  private static class TestClient extends Thread {
    private ThreadLocalDemo sn;

    public TestClient(ThreadLocalDemo sn) {
      this.sn = sn;
    }

    public void run() {
      for (int i = 0; i < 3; i++) {
        // ④每个线程打出3个序列值
        System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                + sn.getNextNum() + "]");
      }
    }

    Integer getThreadLocalDemoNextNum(){
      return sn.getNextNum();
    }
  }
}
