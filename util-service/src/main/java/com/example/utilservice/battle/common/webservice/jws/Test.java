package com.example.utilservice.battle.common.webservice.jws;

import javax.xml.ws.Endpoint;

public class Test {
  public static void main(String[] args) {
    HelloWorld helloWorld=new HelloWorldImpl();
//    @Value("${spring.ws.address}")
    String address = "http://localhost:8002/ws/hello";
    Endpoint.publish(address, helloWorld);

  }
}
