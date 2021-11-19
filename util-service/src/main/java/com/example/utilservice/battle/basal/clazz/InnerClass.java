package com.example.utilservice.battle.basal.clazz;

/**
 * @description: 练习（how2j）
 * @function：内部类——普通内部类、静态内部类、匿名内部类、局部内部类
 * @author: zhaosp1
 * @date: 2021/8/18 13:04
 **/
public class InnerClass {
  //普通内部类
  class Test{
    void show(){
    };
  }

  //静态内部类
  static class Test2{

  }

  public void show(){
    System.out.println("测试方法！");
  }
  public static void main(String[] args) {
    //匿名类
    InnerClass test=new InnerClass(){
      @Override
      public void show() {
        System.out.println("匿名类！");
      }
    };
    test.show();


    //本地类
    class Test3{
      public void show() {
        System.out.println("本地类");
      }
    }
    Test3 test3=new Test3();
    test3.show();
  }
}
