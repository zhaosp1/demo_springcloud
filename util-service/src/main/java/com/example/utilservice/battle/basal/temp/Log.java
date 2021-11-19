package com.example.utilservice.battle.basal.temp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @description: 练习（how2j）
 * @function：使用java默认的日志框架
 * @author: zhaosp1
 * @date: 2021/8/17 23:46
 * 数组的缺点：必须初始化分配数组长度，不可动态增长
 **/
public class Log {
  public static Logger getLogger(String name){
    Logger log=Logger.getLogger(name);
    log.setLevel(Level.INFO);
    return log;
  }
}
