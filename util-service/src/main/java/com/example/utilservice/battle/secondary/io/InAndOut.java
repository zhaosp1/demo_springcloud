package com.example.utilservice.battle.secondary.io;

import java.util.Scanner;

/**
 * @description: 练习（how2j）
 * @function：java的输入输出流练习
 * @author: zhaosp1
 * @date: 2021/8/18 16:04
 **/
public class InAndOut {
  public static void main(String[] args) {
    Scanner sin=new Scanner(System.in);
    String s=sin.nextLine();
    System.out.println(s);
    System.err.println("java的错误输出");
  }
}
