package com.example.utilservice.battle.basal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 练习（how2j）
 * @function：日期类的练习
 * @author: zhaosp1
 * @date: 2021/8/18 0:16
 **/
public class DateDemo {
  public static void main(String[] args) {
    //Date和SimpleDateFormat的使用
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
    String str = "2016/1/5 12:12:12";
    try {
      Date d = sdf.parse(str);
      System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s",str,d.toString());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    //Calendar的使用
    //采用单例模式获取日历对象Calendar.getInstance();
    Calendar c = Calendar.getInstance();
    //通过日历对象得到日期对象
    Date d = c.getTime();
    Date d2 = new Date(0);
    c.setTime(d2); //把这个日历，调成日期 : 1970.1.1 08:00:00
  }
}
