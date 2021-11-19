package com.example.utilservice.battle.common.algorithm;

/**
 * TODO
 * 斐波那契数列的实现
 * 问题描述：在斐波那契数列中，下一个数字是前两个数的和，例如0、1、1、2、3、5、8、13、21、34、55等。斐波那契数列的前两个数是0和1。
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/10 23:58
 */
public class FibonacciExample {
  //使用循环方式实现
  public static void doFibonacci1(int data){
    int t=0,t1=0,t2=1;
    for(int i=1;i<=data;i++){
      if(i==1){
        System.out.println("第"+i+"个数:"+t1);
      }else if(i==2){
        System.out.println("第"+i+"个数:"+t2);
      }else {
        t=t1+t2;
        System.out.println("第"+i+"个数:"+t);
        t1=t2;
        t2=t;
      }
    }
  }

  //使用递归方式实现——书写方便，但容易造成内存溢出
  public static int doFibonacci2(int data){
    if(data>0){
      if(data==1)
      {
        return 0;
      }
      if(data==2){
        return 1;
      }
      else {
        return doFibonacci2(data-1)+doFibonacci2(data-2);
      }
    }else {
      return -1;
    }
  }

  public static void main(String[] args) {
    doFibonacci1(5);
    System.out.println(doFibonacci2(5));
  }
}
