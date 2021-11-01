package com.example.utilservice.util.net.webservice.jws;

import javax.xml.ws.Endpoint;

public class WSServer {

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/ns", new BusinessService());
    System.out.println("webservice publish success.");
  }

}
