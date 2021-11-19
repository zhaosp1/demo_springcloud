package com.example.utilservice.battle.basal.util;

import com.mysql.jdbc.Driver;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：jdbc工具类
 * @date 2021/8/19 0:09
 */
public class JdbcUtil {
  private final String driver;
  private final String url;
  private final String username;
  private final String password;

  public JdbcUtil(String driver, String url, String username, String password) throws ClassNotFoundException {
    this.driver = driver;
    this.url = url;
    this.username = username;
    this.password = password;
    init();
  }

  /**
   * 加载驱动
   * @throws ClassNotFoundException
   */
  private void init() throws ClassNotFoundException {
    Class.forName(driver);
  }

  /**
   * 获得数据库连接
   * @return
   * @throws SQLException
   */
  public Connection getConnection() throws SQLException {
    if (url.contains("mysql"))
      System.out.println("获得mysql连接！");
    else if (url.contains("oracle"))
      System.out.println("获得oracle连接！");
    return DriverManager.getConnection(url, username, password);
  }

  /**
   * 数据库操作语句
   * @param conn
   * @param sql
   * @param params
   * @return
   * @throws Exception
   */
  public Object excuteSql(Connection conn, String sql, String... params) throws Exception {
    Map result = new HashMap<>();
    String type = StringUtil.getDealString(sql.toLowerCase()).split("\\s+")[0];
    result.put("type", type);

    try {
      if (params.length == 0) {
        Statement st = conn.createStatement();
        if ("select".equals(type)) {
          result.put("result", st.executeQuery(sql));
        } else if("insert".equals(type)||"delete".equals(type)||"update".equals(type)){
          result.put("result", st.executeUpdate(sql));
        }else {
          result.put("result",st.execute(sql));
        }
      } else {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i <= params.length; i++) {
          ps.setString(i, params[i]);
        }
        ps.execute();
        result.put("result", ps.getResultSet());
      }
    } catch (Exception e) {
      result.put("status", "fail");
      result.put("description", e.getMessage());
      return result;
    }

    result.put("status", "success");
    return result;
  }

  /**
   * 批量处理语句
   * @param conn
   * @param list
   * @throws Exception
   */
  public static void batchSql(Connection conn, List<String> list) throws Exception {
    final Statement pst = conn.createStatement();
    list.stream().forEach(a -> {
      try {
        pst.addBatch(a);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    });
    pst.executeBatch();
  }

  /**
   * 查询结果输出（自定义）
   * @param object
   * @throws Exception
   */
  public void output(Object object) throws Exception {
    Map map = (Map) object;
    if (String.valueOf(map.get("status")).equals("success")) {
      if (String.valueOf(map.get("type")).equals("select")) {
        System.out.printf("操作类型：%s\n执行状态：%s\n返回结果:\n", map.get("type"), map.get("status"));
        List ll = new ArrayList();
        ResultSet rs = (ResultSet) map.get("result");
        ResultSetMetaData meta = rs.getMetaData();
        List list = new ArrayList();
        for (int i = 0; i < meta.getColumnCount(); i++)
          list.add(meta.getColumnName(i + 1));
        ll.add(list);
        while (rs.next()) {
          List temp = new ArrayList();
          for (int i = 0; i < meta.getColumnCount(); i++)
            temp.add(rs.getString(i + 1));
          ll.add(temp);
        }
        printLine(meta.getColumnCount());
        for (int i = 0; i < ll.size(); i++) {
          List<String> temp = (List<String>) ll.get(i);
          for (String s : temp) {
            System.out.printf("%-32s\t", s);
          }
          System.out.println();
          if (i == 0)
            printLine(meta.getColumnCount());
        }
        printLine(meta.getColumnCount());
      }else {
        System.out.printf("操作类型：%s\n执行状态：%s\n返回结果:影响行数%d行\n", map.get("type"), map.get("status"),map.get("result"));
      }
    } else {
      System.out
        .printf("操作类型：%s\n执行状态：%s\n失败原因：[%s]\n", map.get("type"), map.get("status"), map.get("description"));
    }
  }

  private void printLine(int n) {
    for (int i = 0; i < n * 32; i++)
      System.out.print("_");
    System.out.println();
  }

  public static void main(String[] args) throws ClassNotFoundException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    String user = "root";
    String pass = "20133073";

//    String driver = "oracle.jdbc.driver.OracleDriver"; //oracle的驱动
//    String url = "jdbc:oracle:thin:@localhost:1521/orcl";  //连接oracle路径方式 “”gfs“”是要建立连接的数据库名 1521端口
//    String user = "cd31308";   //user是数据库的用户名
//    String pass = "1";  //用户登录密码
    JdbcUtil mysql = new JdbcUtil(driver, url, user, pass);
    try (Connection conn = mysql.getConnection()) {
      System.out.println("获得连接成功！");
      Object result = mysql.excuteSql(conn, "delete from temp where msg='ceshi4'");
      mysql.output(result);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
