package com.example.utilservice.battle.common.algorithm;

/**
 * 求阶乘
 * 问题描述：
 * Java中的阶乘程序：n的阶乘是所有正降序整数的乘积。n的阶乘由 n! 表示。例如：
 *
 *    4!=  4 * 3 * 2 * 1  =  24
 *    5!=  5 * 4 * 3 * 2 * 1  =  120
 * 4! 的发音为“ 4阶乘”。
 *
 * 阶乘通常用于组合和排列（数学）。
 */
public class FactorialExample {
  //方式一：利用循环来求数的阶乘，特点是节省空间
  public static int factorial1(int i) {
    int s = 1;
    while (i > 0) {
      s = s * i;
      i--;
    }
    return s;
  }

  //方式二：利用递归来求书的阶乘，但如果不对方法进行限制，可能出现栈溢出，例如：参数如负数--这里就不做控制了
  public static int factorial2(int i) {
    if(i==1){
      return i;
    }else {
      return i*factorial2(i-1);
    }
  }
  public static void main(String[] args) {
    System.out.println(factorial1(-2));
    System.out.println(factorial2(-2));
  }
}
