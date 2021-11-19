package com.example.utilservice.battle.common.algorithm;

/**
 * java实现图案打印
 */
public class StarExample {

  //图案一——第n行有n个星，左对齐（每一次循环，先打印星）
  public static void star1(int n){
    for(int i=1;i<=n;i++){
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
    }
  }

  //图案二——第n行有n个星，右对齐（每一次循环，先打印空格，然后打印星）
  public static void star2(int n){
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n-i;j++){
        System.out.print(" ");
      }
      for(int k=1;k<=i;k++){
        System.out.print("*");
      }
      System.out.println();
    }
  }

  //图案三——打印金字塔图形（和图案二一样的设计，只不过打印的*后面添加一个空格）
  public static void star3(int n){
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n-i;j++){
        System.out.print(" ");
      }
      for(int k=1;k<=i;k++){
        System.out.print("* ");
      }
      System.out.println();
    }
  }



  public static void star4(){

  }

  public static void main(String[] args) {
    star3(4);
  }

}
