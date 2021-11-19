package com.example.utilservice.battle.basal;

import java.util.*;

/**
 * @description: 练习（how2j）
 * @function：java的数据类型：基础数值类型、引用类型
 * @author: zhaosp1
 * @date: 2021/8/17 22:39
 **/
public class Variable {
  public static void main(String[] args) {
    //基础数值类型：整布浮（符）。基础类型存储在jvm结构中的栈区
    byte bi=12;       //字节型整数，占1字节，8位（bits）
    short si=12;      //无符号整数，占2字节，16位
    int ii=12;        //符号整数，占4字节，32位
    long lo=12;       //长整数，占8字节，64位
    boolean b=true;   //布尔类型，占1字节，8位，取值范围[true,false]
    char c='c';       //字符类型，占2字节，16位（java是unicode编码，字符使用16位来表示）
    float f=12.0f;    //浮点类型，占4字节，32位（符号位1+指数位8+尾数位24）,系统默认为双浮点类型，所以我们定义float需要添加后缀f
    double d=12.0;    //双浮点类型，占8字节，64位（符号位1+指数位11+尾数位52）

    /**
     * 引用类型：类、枚举类等等。
     * 形如String类似变量的引用值存储在jvm结构中的栈区，但变量结构体的定义却在jvm的堆区的变量，我们称之为引用类型。应用类型的应用值一般指向其变量的定义
     */
    String s="hello java!";
    Integer i=new Integer("12");
    List list=new ArrayList();
    Set set=new HashSet();
    Map map=new HashMap();
  }
}
