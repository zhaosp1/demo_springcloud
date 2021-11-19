package com.example.utilservice.battle.common.algorithm;

/**
 * 求阿姆斯特朗数（水仙花数）
 * 问题描述：Java中的阿姆斯壮数字：如果正整数等于其数字的立方之和，例如0、1、153、370、371、407等，则称为阿姆斯特朗数
 * 例如：153 = (1*1*1)+(5*5*5)+(3*3*3)
 */
public class ArmstrongExample {

  //方式一：通过循环对该数的各个位数进行立方求和与原数进行比较，如果相同则是，否则不是
  public static boolean armstrong1(int n){
    int sum=0,t=0,temp=n;
    while(temp/1!=0){
      t=temp%10;
      sum=sum+t*t*t;
      temp=temp/10;
    }
    if(n==sum){
      return true;
    }else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(armstrong1(153));
  }
}
