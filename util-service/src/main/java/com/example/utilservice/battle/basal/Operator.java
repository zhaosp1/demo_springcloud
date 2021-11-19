package com.example.utilservice.battle.basal;

/**
 * @description: 练习（how2j）
 * @function：java的操作符
 * @author: zhaosp1
 * @date: 2021/8/17 23:09
 **/
public class Operator {
  public static final String t1=" + - *  /  % ";      //java的算数运算符 ”加减乘除模“
  public static final String t2=" >  <  =  >=   <=  ==  !=";    //java的关系运算符   ”大于 小于 等于  不小于  不大于   等于   不等于”


  //无论长路与还是短路与两边的运算单元都是布尔值,都为真时，才为真;任意为假，就为假。区别:长路与 两侧，都会被运算;短路与 只要第一个是false，第二个就不进行运算了
  public static final String t3="&  &&  |   ||  !   ^";     //java的逻辑运算符    “长路与   短路与   长路或   短路或   取反非   亦或”
  public static final String t4="Integer.toBinaryString()  |  &  ^   ~   <<   >>   >>>   <<<";    //java的位操作符   “整数的二进制   位或   位与  异或   取非  左移  右移   无符号右移  无符号左移”
  public static final String t5="= +=  -= *= /= %= &= |= ^= <<= >>= >>>=";  //java的赋值运算符
  public static final String t6="7<8?7:8";   //java的三元操作符
}
