package com.example.utilservice.battle.basal.clazz;

/**
 * @description: 练习（how2j）
 * @function：抽象类——定义了一组属性和行为
 * @author: zhaosp1
 * @date: 2021/8/18 12:42
 **/

/**
 * 抽象类可以有构造方法，但是不能实例化，不能用final、static进行修饰
 */
public abstract class Animal {
  String name;
  String age;
  public Animal(){

  }

  public Animal(String name,String age){
    this.name=name;
    this.age=age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  //抽象方法
  public abstract void belongTo();
}
