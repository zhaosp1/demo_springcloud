package com.example.utilservice.util.net.webservice.jws;


import javax.jws.WebService;
@WebService(endpointInterface= "com.example.utilservice.util.net.webservice.jws.BaseService")
public class BusinessService implements BaseService {
  @Override
  public int add(int a, int b) {
    return a + b ;
  }
  @Override
  public String sayHello(String name) {
    return "hello, " + name;
  }
}
