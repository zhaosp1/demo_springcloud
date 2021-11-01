package com.example.utilservice.util.net.webservice.jws;

import javax.jws.WebService;
@WebService
public interface BaseService {
  public int add(int a,int b);
  public String sayHello(String name);
}
