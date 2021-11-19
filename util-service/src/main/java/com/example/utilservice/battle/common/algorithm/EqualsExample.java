package com.example.utilservice.battle.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/11 13:33
 */
public class EqualsExample {
  public static void main(String[] args) {
    Temp t1=new Temp("tom",12);
    Temp t2=new Temp("tom",12);

    //结果为false，原因是java不会对除String、Integer等类型的自定义类型的equals进行重写，需要由用户自己进行定义
    System.out.println(t1.equals(t2));
  }
}

@Getter
@Setter
@AllArgsConstructor
class Temp{
  private String name;
  private int age;

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Temp temp = (Temp) o;
//    return age == temp.age &&
//            Objects.equals(name, temp.name);
//  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
