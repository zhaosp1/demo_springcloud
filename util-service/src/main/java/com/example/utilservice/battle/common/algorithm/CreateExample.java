package com.example.utilservice.battle.common.algorithm;

import java.lang.reflect.Constructor;

/**
 * java创建对象的方式
 */
public class CreateExample {
  public void show(){
    System.out.println("测试输出！");
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public static void main(String[] args) throws CloneNotSupportedException, IllegalAccessException, InstantiationException, NoSuchMethodException {
    //使用new方式创建
    CreateExample ce=new CreateExample();
    ce.show();

    //通过clone方法创建
    CreateExample ce1=(CreateExample)ce.clone();

    //通过Class的newInstance()来创建
    CreateExample ce2=CreateExample.class.newInstance();

    Constructor<CreateExample> ce3=CreateExample.class.getDeclaredConstructor();
  }
}
