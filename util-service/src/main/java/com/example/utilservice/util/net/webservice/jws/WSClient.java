package com.example.utilservice.util.net.webservice.jws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WSClient {

  public static void main(String[] args) {
    try {
      URL url = new URL("http://localhost:8080/ns?wsdl");
      //命名空间url为实现类的包反写，本地端口为实现类加Service
      QName qName = new QName("http://webservice.util.utilservice.example.com/","BusinessServiceService");
      Service service = Service.create(url,qName);
      BaseService baseService = service.getPort(BaseService.class);
      System.out.println(baseService.add(5, 8));
      System.out.println(baseService.sayHello("xxx"));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

}
