package com.example.utilservice.battle.basal.util;

import cn.hutool.core.thread.ThreadUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SocketUtil {
  static class Server {
    private int server_port = 4775;
    private ServerSocket serverSocket;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    Socket socket;

    public Server() {
      try {
        serverSocket = new ServerSocket(server_port);
        System.out.println("服务器已启动！");
        socket = serverSocket.accept();
        System.out.println("有用户接入了！");
        printWriter = new PrintWriter(socket.getOutputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
          String str = bufferedReader.readLine();
          System.out.println("客户端：" + str);
          if (str.equals("bye")) {
            break;
          }
          printWriter.println(str);
          printWriter.flush();
          System.out.println("发送数据给客户端~");
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          printWriter.close();
          bufferedReader.close();
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
  }


  static class Client{
    Socket socket;
    String address="127.0.0.1";
    int portNumber=4775;
    PrintWriter printWriter;
    BufferedReader bufferedReader;
    public Client(){
      try {
        socket=new Socket(address,portNumber);
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
        } catch (IOException e) {
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

  public static void main(String[] args) throws InterruptedException {
    ThreadUtil.excAsync(()->new Server(),false);
  }
}
