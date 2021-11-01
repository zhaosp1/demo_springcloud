package com.example.utilservice.util.net.socket;

import cn.hutool.core.thread.ThreadUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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

  public static void main(String[] args) {
    ThreadUtil.excAsync(()->new Server(),false);
  }
}