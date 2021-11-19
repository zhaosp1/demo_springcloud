package com.example.utilservice.battle.common.webservice.jws;


import javax.jws.WebService;

@WebService(endpointInterface = "com.example.battle.common.webservice.jws.HelloWorld",serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

  public String sayHi(String text) {
    // TODO Auto-generated method stub
    System.out.println("sayHi called");
    return "Hello " + text;
  }

  public String sayHiToUser(User user) {
    // TODO Auto-generated method stub
    System.out.println("sayHiToUser called");
    return "Hello "+ user.getName() +user.getDescription();
  }

}