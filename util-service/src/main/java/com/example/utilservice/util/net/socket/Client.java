package com.example.utilservice.util.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client{
  Socket socket;
  String address="172.18.16.17";
  int portNumber=4775;
  PrintWriter printWriter;
  BufferedReader bufferedReader;
  public Client(){
    try {
      socket=new Socket(address,portNumber);
      socket.setSoTimeout(10);
      bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      printWriter=new PrintWriter(socket.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void chat(){
    System.out.println("请输入要发送的信息：");
    Scanner scanner=new Scanner(System.in);
    String str="";
    while(true){
      str=scanner.nextLine();
      printWriter.println(str);
      printWriter.flush();
      System.out.println(getCurTime()+"客户端："+str);
      if(str.equals("bye")){
        break;
      }
      String server_str= null;
      try {
        server_str = bufferedReader.readLine();
        System.out.println(getCurTime()+"服务器："+server_str);
      }catch (SocketException e){
        scanner.close();
        close();
        break;
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    scanner.close();
    close();
  }
  public static String getCurTime(){
    Date date=new Date();
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(date);
  }
  public void close(){
    try {
      printWriter.close();
      bufferedReader.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}