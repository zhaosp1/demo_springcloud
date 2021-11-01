package com.example.utilservice.util.net.udp;

import java.net.*;

public class Client {
  private DatagramSocket datagramSocket;
  public Client(){
    datagramSocket=getDatagramSocket("127.0.0.1",6666,20000);
  }
  public Client(String hostname,int port,int timeout){
    datagramSocket=getDatagramSocket(hostname,port,timeout);
  }
  public DatagramSocket getDatagramSocket(String host,int port,int timeout) {
    try {
      DatagramSocket datagramSocket=new DatagramSocket();
      datagramSocket.setSoTimeout(timeout);
      datagramSocket.connect(InetAddress.getByName(host),port);
      return datagramSocket;
    }catch (SocketException s){
      System.out.println("初始化失败！"+s.getMessage());
      return null;
    }catch (UnknownHostException u){
      System.out.println("建立连接失败！"+u.getMessage());
      return null;
    }catch (Exception e){
      System.out.println("失败原因"+e.getMessage());
      return null;
    }

  }

  public void sendData(byte[] data){
    try {
      DatagramPacket packet = new DatagramPacket(data, data.length);
      datagramSocket.send(packet);
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  public String receiveData(){
    try {
      byte[] buffer = new byte[1024];
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      datagramSocket.receive(packet);
      System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));
      return new String(packet.getData(), packet.getOffset(), packet.getLength());
    }catch (Exception e){
      System.out.println(e.getMessage());
      return "";
    }
  }
  public void close(){
    if(datagramSocket.isConnected()){
      datagramSocket.close();
    }
  }

  public static void main(String[] args) throws Exception {


//    ThreadUtil.excAsync(()->new Client().receiveData(),false );
  }
}
