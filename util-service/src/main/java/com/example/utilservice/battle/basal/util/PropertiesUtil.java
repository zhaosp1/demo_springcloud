package com.example.utilservice.battle.basal.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @description: 练习（how2j）
 * @function：PropertiesUtil工具类
 * @author: zhaosp1
 * @date: 2021/8/20 12:50
 **/
public class PropertiesUtil {
  /**
   * 获取当前项目类的默认路径
   * @return
   */
  public static String getClassPath(){
    return PropertiesUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
  }

  /**
   * 获取当前操作系统
   * @return
   */
  public static String getDefaultOS(){
    return System.getProperty("os.name");
  }

  /**
   * 获取当前服务器用户
   * @return
   */
  public static String getDefaultUser(){
    return System.getProperty("user.name");
  }

  /**
   * 获取当前系统的默认字符编码
   * @return
   */
  public static String getDefaultCharset(){
    return Charset.defaultCharset().name();
  }


  //三种方式获取配置信息：Porperties类加载配置文件流、ResourceBundle类加载properties文件
  //获取classpath——代码编译类路径
  public static String getClassPath(Class className){
    String classpath=className.getClassLoader().getResource("").toString();
    int index=classpath.indexOf(":")+2;
    return classpath.substring(index);
  }


  //类加载器——通过Properties类进行读取属性配置
  public static void test1() throws IOException {
    InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config/config.properties");
    Properties properties = new Properties();
    properties.load(in);
    System.out.println(
      "username:" + properties.getProperty("username") + "\tpassword:" + properties.getProperty("password"));

  }


  //字符流——通过对字符流文件进行读取
  public static void loadProperties(String fileName) throws IOException {
    Properties properties = new Properties();
    // 使用InPutStream流读取properties文件
    BufferedReader bufferedReader = new BufferedReader(
      new FileReader("C:\\Users\\demo\\Desktop\\config.txt"));
    properties.load(bufferedReader);
    // 获取key对应的value值
    System.out.println(properties.getProperty("username"));
  }

  //resourcebundle类——默认以.txt为结尾
  public static void test3() throws IOException {
    ResourceBundle resource = ResourceBundle.getBundle("config/config");
    String username = resource.getString("username");
    System.out.println(username);
  }
  public static void main(String[] args) {
    System.out.println(getDefaultUser());
  }
}
