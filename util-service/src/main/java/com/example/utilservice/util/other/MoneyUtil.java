package com.example.utilservice.util.other;

import java.util.Scanner;

//题目描述：小明手中有 1，5，10，50，100 五种面额的纸币，每种纸币对应张数分别为 5，2，2，3，5 张。若小明需要支付 456 元，则需要多少张纸币？
public class MoneyUtil {

  public static int count(int money) throws Exception{
    if(money<0)throw new Exception("输入金额为负数，请纠正后重新进行输入");
    int[] VALUE=new int[]{1,5,10,50,100};
    int[] COUNT=new int[]{5,2,2,3,5};
    int num=0;

    for(int i=VALUE.length-1;i>=0;i--){
      int t=Math.min(money/VALUE[i],COUNT[i]);
      money-=VALUE[i]*t;
      num+=t;
    }

    if(money>0){
      num=-1;
    }
    return num;
  }

  public static void main(String[] args)  throws Exception{
    try(Scanner sin=new Scanner(System.in)){
      int money=sin.nextInt();
      int num=count(money);

      if(num!=-1){
        System.out.printf("%d块钱至少需要%d张纸币！",money,num);
      }else {
        System.out.printf("%d块钱大于兑换钱币总和，或者不符合规范",money);
      }
    }
  }
}
