package com.example.utilservice.battle.basal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 练习（how2j）
 * @function：DateUtil工具类
 * @author: zhaosp1
 * @date: 2021/8/19 13:43
 **/
public class DateUtil {
  /**
   * 获取系统日期
   * @return
   */
  public static String getNowDate(String regrex) throws ParseException {
    String dateTime = new SimpleDateFormat(regrex).format(new Date());
    return dateTime;
  }

  public static void main(String[] args) throws ParseException {
    System.out.println(getNowDate("yyyy年MM月dd日"));
  }
}
