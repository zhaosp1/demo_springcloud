package com.example.utilservice.battle.basal.temp;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：一个临时工具类
 * @date 2021/8/18 22:50
 */
public class Temp {
  public static void excute(int times, Action action) {
    if (times < 0) {
      return;
    }
    for (int i = 0; i < times; i++) {
      action.excute();
    }
  }
}
