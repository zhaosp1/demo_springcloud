package com.example.utilservice.battle.basal;

import java.util.Arrays;

/**
 * @description: 练习（how2j）
 * @function：数组结构的练习
 * @author: zhaosp1
 * @date: 2021/8/17 23:46
 * 数组的缺点：必须初始化分配数组长度，不可动态增长
 **/
public class ArraysDemo {
  public static void main(String[] args) {
    //数组的定义以及初始化
    int[] array1 = new int[5];
    array1[0] = 2;
    array1[1] = 5;
    array1[2] = 1;
    array1[3] = 6;
    array1[4] = 8;
    int[] array2 = { 1, 4, 8, 6, 2 };
    int[] array3 = new int[] { 100, 102, 444, 836, 3236 };

    //数组的遍历
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }
    for (int t : array1) {
      System.out.println(t);
    }

    //数组的复制
    int[] array4 = new int[array1.length];
    System.arraycopy(array1, 0, array4, 0, array1.length);


    //二维数组的表示
    int[][] array5=new int[][]{
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };


    //Arrays工具类的使用
    int[] temp = Arrays.copyOfRange(array1, 0, 3);//数组复制
    System.out.println(Arrays.toString(array1));//数组转换为字符串
    Arrays.sort(array1);//数组的排序
    Arrays.binarySearch(array1,2);//数组中指定数的查找
    Arrays.equals(array1,array2);//判断两个数组内容是否相同
    Arrays.fill(array3,0);//数组的填充
  }
}
