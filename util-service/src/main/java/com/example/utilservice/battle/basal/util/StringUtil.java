package com.example.utilservice.battle.basal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：StringUtil工具类
 * @date 2021/8/19 0:15
 */
public class StringUtil {
  private static final String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

  /**
   * 获取当前纯字符串（用于sql语句预处理）
   * @param s
   * @param params
   * @return
   */
  public static String getDealString(String s,String... params){
    Pattern p;
    if(params.length==0){
      p = Pattern.compile(regEx);
    }else {
      p=Pattern.compile(params[0]);
    }
    return p.matcher(s).replaceAll(" ");
  }

  public static int getIndex(String s,String index){
    return s.trim().indexOf(index);
  }
  public static void main(String[] args) {
    System.out.println(getDealString("select * from haha").indexOf("select"));
  }
}
