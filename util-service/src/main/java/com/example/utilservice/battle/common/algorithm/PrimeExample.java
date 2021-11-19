package com.example.utilservice.battle.common.algorithm;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求质数
 * 问题描述：质数是一个大于1并除以1的整形数字，或者仅是其自身。换句话说，素数不能除以自身或1以外的其他数。例如，2、3、5、7、11、13、17 ...是素数。
 * 注意：0和1不是质数。2是唯一的偶数素数，因为所有其他偶数都可以除以2。
 */
public class PrimeExample {
  /**
   * 方式一——平方根求法
   * 算法思想：因为如果一个数不是素数是合数，那么一定可以由两个自然数相乘得到。
   * 其中一个大于或等于它的平方根，一个小于或等于它的平方根，并且成对出现。
   * 任意数m=a*b，设a>=b
   * m=a*b>=b^2
   */
  public static boolean prime1(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  /**
   * 方式二——穷举法
   * 算法思想：通过循环遍历验证每一个数是否为质数或偶数，特点是时间复杂度高,比较次数小于n的一半，原因是
   */
  public static boolean prime2(int n) {
    if (n <= 1) {
      return false;
    } else {
      for (int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
          return false;
        }
      }
      return true;
    }
  }

  public static List<Integer> rangePrime(int a,int b){
    int start,end;
    if(a>b){
      start=b;end=a;
    }else{
      start=a;end=b;
    }
    List<Integer> list=new ArrayList<>();
    for(int i=start;i<=end;i++){
      if(prime1(i)){
        list.add(i);
      }
    }
    return list;
  }
  public static void main(String[] args) {
    //求两个数之间的质数
    Scanner in = new Scanner(System.in);
    int start = in.nextInt();
    int end=in.nextInt();
    System.out.println(start+"\t"+end+"之间质数有：");
    for(int t:rangePrime(start,end)){
      System.out.print(t+"\t");
    }



//    //判断一个数是偶数还是质数
//    Scanner in = new Scanner(System.in);
//    int i = in.nextInt();
//
//    if (i < 2) {
//      System.out.println(i+"不是质数或偶数");
//    } else if (i==2) {
//      System.out.println(i+"既是质数也是偶数");
//    } else {
//      if (prime2(i)) {
//        System.out.println(i + "是质数(素数)！");
//      } else {
//        System.out.println(i + "是偶数(合数)！");
//      }
//    }
  }
}
