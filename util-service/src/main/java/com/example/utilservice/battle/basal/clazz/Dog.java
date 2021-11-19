package com.example.utilservice.battle.basal.clazz;

/**
 * @description: 练习（how2j）
 * @function：面向对象——实体类
 * @author: zhaosp1
 * @date: 2021/8/18 12:45
 **/

/**
 * 在Java继承里，父类的属性还有方法在声明时，如果是public关键字即公共属性，则在子类继承时，这些属性和方法都会被子类继承。受保护的也可以继承
 * 但是私有的类属性成员和方法则无法继承。
 */
public class Dog extends Animal{
  public Dog(){

  }
  public Dog(String name,String age){
    super(name,age);
  }
  @Override
  public void belongTo() {
    System.out.println(super.getName()+"今年"+super.getAge()+"岁，属于犬类！");
  }

  public void belongTo(String s){
    System.out.println("重载测试！");
  }
}
