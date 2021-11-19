package com.example.utilservice.battle.secondary.exception;

import java.io.File;
import java.io.FileInputStream;

/**
 * @description: 练习（how2j）
 * @function：java异常处理
 * @author: zhaosp1
 * @date: 2021/8/18 15:47
 **/
public class ExceptionDemo {
  //自定义异常
  class MyException extends Exception{
    public MyException(){

    }
    public MyException(String msg){
      super(msg);
    }
  }

  //throws方式是声明异常，将异常交给外层方法进行捕获处理
  public static void throwsTest() throws MyException{
    int i=2/0;
  }

  public static void main(String[] args) {
    File file;
    try {
      file = new File("C:\\Users\\demo\\Desktop\\12345678.txt");
      System.out.println("文件名为：" + file.getName());
      FileInputStream fin = new FileInputStream(file);
    } catch (Exception e) {
//      System.out.println(e.getMessage());
      e.printStackTrace();
    }finally {
      System.out.println("结束时执行语句！");
    }
  }
}
