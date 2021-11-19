package com.example.utilservice.battle.common.algorithm;

import java.util.Scanner;

/**
 * TODO
 * 回文数
 * 问题描述：Java中的回文数，回文数是反向后相同的数字。例如545、151、34543、343、171、48984是回文数。它也可以是LOL，MADAM等字符串。
 */
public class PalindromeExample {
  /**
   * 方法一：将输入数转换为字符串，通过字符串转换来求是否与原字符串相同，相同为回文数，不同则不是
   * 如果是在c语言中，则需要通过从后遍历比较从前遍历的字符，相同则为回文数，不同则不是
   */
  public static boolean palindrome1(String s) {
    String t = new StringBuilder(s).reverse().toString();
    if (t != null && t.equals(s)) {
      return true;
    } else {
      return false;
    }
  }


  //方式2——方式一的变形，不借助string的倒置方法
  public static boolean palindrome2(String s) {
    if(s!=null){
      char[] c=s.toCharArray();
      for(int i=0;i<c.length;i++){
        if(c[i]!=c[c.length-i-1]){
          return false;
        }
      }
      return true;
    }
    return false;
  }

  //方式三——判断整数是否为回文数
  public static boolean palindrome3(int s) {
    int temp=0,t=0,n=s;
    while(n/1!=0){
      t=n%10;
      temp=temp*10+t;
      n=n/10;
    }
    if(s==temp){
      return true;
    }else {
      return false;
    }
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int s=in.nextInt();
    if(palindrome3(s)){
      System.out.println(s+"是回文数");
    }else{
      System.out.println(s+"不是回文数");
    }
  }
}
