//package com.example.utilservice.util.net.webservice.xfire;
//
//
//import org.codehaus.xfire.client.Client;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.net.URL;
//
//@Component
//public class XFireClient {
//  private final static Logger log = LoggerFactory.getLogger(XFireClient.class);
//
//  public static void main(String[] args) throws Exception {
//
//    String xfireUrl = "http://localhost:8080/xfire/xfireServiceShell?wsdl";
//    String namespaceURI = "http://impl.service.ws.gblfy.com";
//    //单个参数
//    String method = "sayHello";
//
//    //多参
//    // String method = "sayHello2";
//    String reqXml = "1";
//    String reqXml2 = "2";
//
//    //调用服务
//    XFireClient.xfireSendMsg(xfireUrl, namespaceURI, method, reqXml);
//    // XFireClient.xfireSendMsg(xfireUrl, namespaceURI, method, reqXml, reqXml2);
//  }
//
//
//  /**
//   * 单参调用工具类
//   *
//   * @param xfireUrl url地址
//   * @param method   调用方法名
//   * @param reqXml   发送报文体
//   * @return res 返回结果
//   * @throws Exception 若有异常，在控制台输出异常，并将异常抛出
//   */
//  public static String xfireSendMsg(String xfireUrl, String namespaceURI, String method, String reqXml) throws Exception {
//    // 创建服务
//    Client client = new Client(new URL(xfireUrl));
//    // 设置调用的方法和方法的命名空间
//    client.setProperty(namespaceURI, method);
//    // 通过映射获得结果
//    Object[] result = new Object[0];
//    try {
//      result = client.invoke(method, new Object[]{reqXml});
//    } catch (Exception e) {
//      e.printStackTrace();
//      throw e;
//    }
//    String xml = (String) result[0];
//    log.info("响应报文 : {}", xml);
//    return xml;
//  }
//
//  /**
//   * 多参调用工具类（Object类型）
//   *
//   * @param xfireUrl url地址
//   * @param method   调用方法名
//   * @param reqXml   发送报文体
//   * @return res 返回结果
//   * @throws Exception 若有异常，在控制台输出异常，并将异常抛出
//   */
//  public static String xfireSendMsg(String xfireUrl, String namespaceURI, String method, String reqXml, String reqXml2) throws Exception {
//
//    // 创建服务
//    Client client = new Client(new URL(xfireUrl));
//    // 设置调用的方法和方法的命名空间
//    client.setProperty(namespaceURI, method);
//    // 通过映射获得结果
//    Object[] result = new Object[0];
//    try {
//      result = client.invoke(method, new Object[]{reqXml, reqXml2});
//    } catch (Exception e) {
//      e.printStackTrace();
//      throw e;
//    }
//    String xml = (String) result[0];
//    log.info("响应报文 : {}", xml);
//    return xml;
//  }
//}
//
