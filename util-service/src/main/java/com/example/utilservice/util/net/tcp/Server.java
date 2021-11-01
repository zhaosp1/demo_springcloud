package com.example.utilservice.util.net.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class Server{
  public Server(){
    try{
      ServerSocket ss=new ServerSocket(8888);
      System.out.println("服务器开始运行...");

      for(;;) {
        Socket s=ss.accept();
        System.out.println("来自ip="+s.getRemoteSocketAddress());
      }
    }catch (Exception e){

    }
  }
  public static void main(String[] args) throws Exception{

  }
}