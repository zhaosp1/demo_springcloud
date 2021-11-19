package com.example.utilservice.battle.basal;

import java.util.StringJoiner;

/**
 * @description: 练习（how2j）
 * @function：字符串练习
 * @author: zhaosp1
 * @date: 2021/8/18 0:01
 **/
public class StringDemo {
  public static void main(String[] args) {
    String s="Hello World!";
    s.toLowerCase();//字符串转换为小写
    s.toUpperCase();//字符串转换为大写
    s.replaceAll(" ","-");//字符串指定字符替换
    s.indexOf("Hello");//指定字串的查找
    s.equals("hello world");//字符串比较
    char[] cs=s.toCharArray();//转换为字符数组
    s.trim();//去掉收尾空格
    boolean flag=s.contains("hello");//包含字串
    s.substring(2);//截取字串

    //动态字符串
    StringBuilder sbd=new StringBuilder(s);
    StringBuffer sbf=new StringBuffer(s);

    //连接字符串与String.join()方法作用相同
    StringJoiner sj=new StringJoiner(",");
    sj.add("1");sj.add("1");sj.add("1");sj.add("1");
    System.out.println(sj.toString());

    String[] st={"dsf","fs","jjsf","fs"};
    System.out.println(String.join("-",st));
  }
}
