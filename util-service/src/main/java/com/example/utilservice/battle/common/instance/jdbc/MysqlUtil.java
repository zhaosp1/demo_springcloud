package com.example.utilservice.battle.common.instance.jdbc;

import cn.hutool.core.io.FileUtil;
import com.example.utilservice.battle.basal.util.JdbcUtil;


import java.io.FileOutputStream;
import java.sql.*;
import java.util.UUID;

/**
 * 注意：旧版mysql的语句需要对表名、字段使用``进行标注，否则会报语法错误
 */
public class MysqlUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return new JdbcUtil("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf-8", "root", "20133073").getConnection();
    }
    /**
     * 向oracle数据库存入文件
     */
    public void save(){
        ResourceDTO resourceDTO= ResourceDTO.builder().key(UUID.randomUUID().toString()).name("test.txt").description("测试支持").value(
                FileUtil.getInputStream("C:\\Users\\luck dog\\Desktop\\简言之.txt")).build();
        try(Connection con=getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `resource` (`key`, `name`, `description`, `value`) VALUES (?,?,?,?)");
            ps.setString(1,resourceDTO.getKey());
            ps.setString(2,resourceDTO.getName());
            ps.setString(3,resourceDTO.getDescription());
            ps.setBlob(4,resourceDTO.getValue());

            ps.execute();
//            System.out.println(i+" 条记录被影响！");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 从数据库中读取文件流
     */
    public void get(){
        try(Connection con=getConnection()) {
            PreparedStatement ps = con.prepareStatement("select `key`,`name`,`description`,`value` from resource");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Blob b = rs.getBlob(4);
                byte barr[] = b.getBytes(1, (int) b.length());
                FileOutputStream fout = new FileOutputStream("C:\\Users\\luck dog\\Desktop\\11111111111111.txt");
                fout.write(barr);
                con.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new MysqlUtil().get();
//        new MysqlUtil().save();
    }
}