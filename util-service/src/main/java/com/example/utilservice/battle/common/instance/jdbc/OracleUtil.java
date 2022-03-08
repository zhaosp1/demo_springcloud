package com.example.utilservice.battle.common.instance.jdbc;

import cn.hutool.core.io.FileUtil;
import com.example.utilservice.battle.basal.util.JdbcUtil;


import java.io.FileOutputStream;
import java.sql.*;

public class OracleUtil {
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    return new JdbcUtil("oracle.jdbc.OracleDriver","jdbc:oracle:thin:@127.0.0.1:1521/orcl", "root", "1").getConnection();
  }
  /**
   * 向oracle数据库存入文件
   */
  public void save(){
    ResourceDTO resourceDTO= ResourceDTO.builder().key("test").name("test.txt").description("测试上传!").value(
      FileUtil.getInputStream("C:\\Users\\alice\\Desktop\\日志(4).txt")).build();
    try(Connection con=getConnection())  {
      PreparedStatement ps = con.prepareStatement("INSERT INTO REPOSITORY(KEY,NAME,DESCRIPTION,VALUE) VALUES (?,?,?,?)");
      ps.setString(1,resourceDTO.getKey());
      ps.setString(2,resourceDTO.getName());
      ps.setString(3,resourceDTO.getDescription());
      ps.setBlob(4,resourceDTO.getValue());

      ResultSet rs = ps.executeQuery();
      int i=ps.executeUpdate();
      System.out.println(i+" 条记录被影响！");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static void main(String[] args) {
    try(Connection con=getConnection()) {
      PreparedStatement ps = con.prepareStatement("select KEY,NAME,DESCRIPTION,VALUE from REPOSITORY");
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Blob b = rs.getBlob(4);
        byte barr[] = b.getBytes(1, (int) b.length());
        FileOutputStream fout = new FileOutputStream("C:\\Users\\alice\\Desktop\\11111111111111.txt");
        fout.write(barr);
        con.close();
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
}