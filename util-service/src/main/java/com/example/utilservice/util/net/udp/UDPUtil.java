package com.example.utilservice.util.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：SocketUtil工具类
 * @date 2021/8/19 0:13
 */
public class UDPUtil {
  private String flag;

  private String content;

  public UDPUtil(String flag) {
    this.flag = flag;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void run() {
    try {
      if (flag.equals("1")) {
        System.out.println("send");
        send(content);
      } else {
        System.out.println("receive");
        receive();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void send(String s) throws IOException {

    DatagramSocket ds = new DatagramSocket(3000);
    InetAddress ip = InetAddress.getByName("127.0.0.1");

    DatagramPacket dp = new DatagramPacket(s.getBytes(), s.length(), ip, 3000);
    ds.send(dp);
    System.out.println(s);
    ds.close();

  }

  private void receive() throws IOException {
    DatagramSocket ds = new DatagramSocket(3000);
    byte[] temp = new byte[1024];

    DatagramPacket dp = new DatagramPacket(temp, 1024);
    System.out.println("ok");
    ds.receive(dp);
    String str = new String(dp.getData(), 0, dp.getLength());
    System.out.println(str);
    ds.close();
  }


}
