package com.example.utilservice.util.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
  public void doGet(String httpurl) throws Exception {
    HttpURLConnection connection = null;
    InputStream in = null;
    BufferedReader br = null;

    URL url = new URL(httpurl);
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setConnectTimeout(15000);
    connection.setReadTimeout(5000);
    connection.connect();

    StringBuffer sb = new StringBuffer();
    if (connection.getResponseCode() == 200) {
      in = connection.getInputStream();
      br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
      String temp = null;
      while ((temp=br.readLine())!= null) {
        sb.append(temp);
        sb.append("\r\n");
      }
    }

    System.out.println(sb.toString());
    if (null != br) {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (null != in) {
      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    connection.disconnect();// 关闭远程连接
  }

  public static void main(String[] args) throws Exception {
    new Client().doGet("http://localhost:8080/server");
  }
}