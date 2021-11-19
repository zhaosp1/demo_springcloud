package com.example.utilservice.battle.basal;

import java.util.Random;

/**
 * @description: 练习（how2j）
 * @function：java的流程控制
 * @author: zhaosp1
 * @date: 2021/8/17 23:35
 **/
public class Control {
  public static void main(String[] args) {
    int flag=10;
    //顺序控制
    System.out.println("这是一个顺序语句！");

    //分支控制
    //if……else if……else分支结构
    if(10>20){
      System.out.println("不可能");
    }else if(10>5){
      System.out.println("这是一个判断语句");
    }else {
      System.out.println("其它输出");
    }
    //switch分支结构
    switch (flag){
    case 1:
      System.out.println("1");
      break;
    case 2:
      System.out.println("2");
      break;
    case 3:
      System.out.println("3");
    case 4:
      System.out.println("4");
    case 5:
      System.out.println("5");
    default:
      System.out.println("其它处理");
    }

    //循环控制
    //for循环结构
    for(int i=0;i<10;i++){
      if(i==3){
        continue;
      }
      if(i==8){
        break;
      }
    }

    //while循环结构
    int i=10;
    while(i>0){
      System.out.println("大于0继续循环");
      i--;
    }

    //do……while循环结构
    do{
      System.out.println("小于10继续循环");
      i++;
    }while (i<10);
  }
}
