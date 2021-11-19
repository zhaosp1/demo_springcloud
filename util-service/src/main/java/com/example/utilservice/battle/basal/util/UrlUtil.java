package com.example.utilservice.battle.basal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：UrlUtil工具类
 * @date 2021/8/19 0:12
 */
public class UrlUtil {
  /**
   * URLConnection——打印url的响应页面
   * @param url
   * @throws IOException
   */
  public static void outputURL(URL url) throws IOException {
    URLConnection conn=url.openConnection();
    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

    String line;
    while((line=br.readLine())!=null){
      System.out.print(line);
    }
  }

  /**
   * URL——打印指定url的连接信息
   * @param s
   * @throws MalformedURLException
   */
  public static void getMetaMsg(String s) throws MalformedURLException {
    URL url=new URL(s);

    System.out.println("协议："+url.getProtocol());
    System.out.println("主机名："+url.getHost());
    System.out.println("端口："+url.getPort());
    System.out.println("文件："+url.getFile());
    System.out.println("传参："+url.getQuery());
  }

  public static void main(String[] args) throws IOException {
    outputURL(new URL("http://www.baidu.com/"));
    getMetaMsg("http://www.baidu.com/");
  }
}
