package com.example.utilservice.battle.common.datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 数组链表——自定义数组链表
 * 主要方法：
 * 增加：add、insertBefore、insertAfter
 * 删除：remove
 * 修改：set
 * 查询：get
 *
 * 优化方法——自调节adjust、获取容量size、构造方法等等。
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/8/15 9:15
 */
public class ArrayStruct {
  private final int DEFAULT = 10;
  private int flag;
  private int max;
  private Object[] temp;

  public ArrayStruct() {
    this.temp = new Object[DEFAULT];
  }

  public ArrayStruct(int capacity) {
    this.temp = new Object[capacity];
    this.max = capacity;
    this.flag = 0;
  }

  //链表的长度
  private int size() {
    return this.flag;
  }

  /**
   * 增加一个结点
   *
   * @param object
   */
  public void add(Object object) {
    temp[this.flag] = object;
    this.flag++;
    adjust();
  }

  /**
   * 在指定位置前插入
   *
   * @param index
   * @param object
   */
  public void insertBefore(int index, Object object) {
    if (index < this.flag - 1 && index > -1) {
      for (int i = this.flag; i >= index; i--) {
        temp[i + 1] = temp[i];
      }
      temp[index] = object;
      this.flag++;
      adjust();
    } else {
      throw new ArrayIndexOutOfBoundsException("size=" + (this.flag) + ",max=" + (this.flag - 1) + ",index=" + index);
    }
  }

  /**
   * 在指定位置后插入
   *
   * @param index
   * @param object
   */
  public void insertAfter(int index, Object object) {
    index++;
    insertBefore(index, object);
  }

  /**
   * 删除指定索引的结点
   *
   * @param index
   */
  public void remove(int index) {
    for (int i = index; i < this.flag - 1; i++) {
      temp[i] = temp[i + 1];
    }
    flag--;
    adjust();
  }

  /**
   * 修改指定索引的值
   *
   * @param index
   */
  public void set(int index, Object object) {
    if (index < this.flag && index > -1) {
      temp[index] = object;
    } else {
      throw new ArrayIndexOutOfBoundsException("size=" + (this.flag) + ",max=" + (this.flag - 1) + ",index=" + index);
    }
  }

  /**
   * 求指定索引的结点值
   *
   * @param index
   * @return
   */
  public Object get(int index) {
    if (index < this.flag && index > -1) {
      System.out.println(this.flag);
      return temp[index];
    } else {
      throw new ArrayIndexOutOfBoundsException("size=" + (this.flag) + ",max=" + (this.flag - 1) + ",index=" + index);
    }
  }

  //内部数组自调整
  private void adjust() {
    if (this.flag >= this.max) {
      Object[] ti = temp;
      temp = new Object[this.max * 2];
      System.arraycopy(ti, 0, temp, 0, this.max);
      this.max = this.max * 2;
      ti = null;
    } else if (this.flag < this.max / 2) {
      Object[] ti = temp;
      temp = new Object[this.max / 2];
      System.arraycopy(ti, 0, temp, 0, this.flag);
      this.max = this.max / 2;
      ti = null;
    }
  }

  @Override
  public String toString() {
    StringJoiner sj = new StringJoiner(",");
    for (int i = 0; i < flag; i++) {
      sj.add(String.valueOf(temp[i]));
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    ArrayStruct as = new ArrayStruct(1);
    as.add("temp");
    as.add("hello");
    as.add("hello");
    as.add("temp");
    as.add("hello");
    as.add("hello");
    as.add("temp");
    as.add("hello");
    as.add("hello");
    as.add("temp");
    as.add("hello");
    as.add("hello");
    as.insertAfter(0, "haha");
    System.out.println(as.toString());
    System.out.println(as.size());
//    System.out.println(String.valueOf(as.get(11)));
  }
}
