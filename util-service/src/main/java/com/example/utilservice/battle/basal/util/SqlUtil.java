package com.example.utilservice.battle.basal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 练习（how2j）
 * @function：SqlUtil（用于动态生成sql语句）
 * @author: zhaosp1
 * @date: 2021/8/24 23:13
 **/
public class SqlUtil {
  /**
   * 查询语句生成
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateSelect(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    for (int i = 0; i < colnums.length; i++) {
      sb.append(colnums[i]);
      if (i < colnums.length - 1) {
        sb.append(",");
      }
    }
    sb.append(" from ").append(tableName).append(";");
    return sb.toString();
  }

  /**
   * 查询语句生成（默认小写）
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateSelectForDefaultAlias(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("select ");
    for (int i = 0; i < colnums.length; i++) {
      sb.append("b."+colnums[i]).append(" as ").append(colnums[i].toLowerCase());
      if (i < colnums.length - 1) {
        sb.append(",");
      }
    }
    sb.append(" from ").append(tableName).append(";");
    return sb.toString();
  }

  /**
   * alter语句生成
   * @param tableName
   * @param colnums
   * @return
   */
  public static String generateAlter(String tableName, String... colnums) {
    StringBuilder sb = new StringBuilder();
    sb.append("alter table ").append(tableName).append(" add (");
    for (int i = 0; i < colnums.length; i++) {
      sb.append(colnums[i]).append(" varchar(20)");
      if (i < colnums.length - 1) {
        sb.append(",");
      }
    }
    sb.append(");");
    return sb.toString();
  }

  public static void main(String[] args) {

  }
}
