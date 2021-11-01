package com.example.utilservice.util.net.http;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：HttpUtil工具类
 * @date 2021/8/19 0:12
 */
public class HttpUtil {

  private String defaultContentEncoding;

  public HttpUtil() {
    this.defaultContentEncoding = Charset.defaultCharset().name();
  }

  /**
   * 设定http的默认编码
   * @param defaultContentEncoding
   */
  public void setDefaultContentEncoding(String defaultContentEncoding) {
    this.defaultContentEncoding = defaultContentEncoding;
  }

  /**
   * 获取http默认的编码
   * @return
   */
  public String getDefaultContentEncoding() {
    return defaultContentEncoding;
  }

  /**
   * HttpURLConnection——读取http信息
   * @param url
   * @throws IOException
   */
  public static void getMetaMsg(URL url) throws IOException {
    URLConnection conn = url.openConnection();
    HttpURLConnection http = (HttpURLConnection) url.openConnection();

    int i = 1;
    while (http.getHeaderFieldKey(i) != null) {
      System.out.println(http.getHeaderFieldKey(i) + " = " + http.getHeaderField(i));
      i++;
    }
  }

  /**
   * InetAddress——打印ip的信息
   * @param name
   * @throws IOException
   */
  public static void outputIP(String name) throws IOException {
    InetAddress ip = InetAddress.getByName(name);

    System.out.println("Host Name: " + ip.getHostName());
    System.out.println("IP Address: " + ip.getHostAddress());
  }



  /**
   * http的post请求
   *
   * @param urlString ַ
   * @param params
   * @param propertys
   * @return
   * @throws IOException
   */
  public static String sendPost(String urlString, Map<String, String> params, Map<String, String> propertys)
    throws IOException {
    return send(urlString, "POST", params, propertys);
  }

  /**
   * http请求
   *
   * @param urlString
   * @param method
   * @param parameters
   * @param propertys
   * @return
   */
  private static String send(String urlString, String method, Map<String, String> parameters,
    Map<String, String> propertys) {
    HttpURLConnection urlConnection = null;
    URL url = null;
    boolean sendSuccess = true;
    try {
      url = new URL(urlString);
    } catch (MalformedURLException e) {
      sendSuccess = false;
    }
    try {
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.setRequestMethod(method);
      urlConnection.setDoOutput(true);
      urlConnection.setDoInput(true);
      urlConnection.setUseCaches(false);
      urlConnection.setConnectTimeout(15000);
      urlConnection.setReadTimeout(15000);
      urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    } catch (ProtocolException e) {
      sendSuccess = false;
    } catch (IOException r) {
      sendSuccess = false;
    }
    if (propertys != null) {
      for (String key : propertys.keySet()) {
        urlConnection.addRequestProperty(key, propertys.get(key));
      }
    }
    if (method.equalsIgnoreCase("POST") && parameters != null) {
      JSONObject param = JSONObject.fromObject(parameters);
      try {
        String str = param.toString();
        //TODO 编码问题
        String strfinal = str.replace("\n", "").replace("\r", "").replace("/r", "").replace("/n", "");
        urlConnection.getOutputStream().write(strfinal.getBytes());
        urlConnection.getOutputStream().flush();
        urlConnection.getOutputStream().close();
      } catch (IOException e) {
        sendSuccess = false;
      }
    }
    return makeContent(urlString, urlConnection);
  }

  /**
   * 获取响应内容
   * @param urlString
   * @param urlConnection
   * @throws IOException
   */
  private static String makeContent(String urlString, HttpURLConnection urlConnection) {

    StringBuffer temp = null;
    try {
      if (urlConnection.getResponseCode() == 200) {
        InputStream in = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        temp = new StringBuffer();
        String line = bufferedReader.readLine();
        while (line != null) {

          temp.append(line).append("\r\n");
          line = bufferedReader.readLine();
        }
        bufferedReader.close();
      }

    } catch (IOException e) {
      // TODO: handle exception
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
    }
    String strfinal = temp.toString();
    return strfinal;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(sendPost("http://www.baidu.com/",null,null));
  }
}