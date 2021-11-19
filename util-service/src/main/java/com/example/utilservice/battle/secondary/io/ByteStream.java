package com.example.utilservice.battle.secondary.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @description: 练习（how2j）
 * @function：字节流基本操作
 * @author: zhaosp1
 * @date: 2021/8/18 16:04
 **/
public class ByteStream {

  /**
   * 字节流文件读取
   * @throws IOException
   */
  public static void readByByteStream() throws IOException {
    FileInputStream fin=null;
    try {
      File file=new File("C:\\Users\\demo\\Desktop\\req-0260查余额.txt");
      fin=new FileInputStream(file);
      byte[] temp=new byte[1024];
      int length=0;
      while((length=(fin.read(temp)))!=-1){
        System.out.println(new String(temp,0,length));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      fin.close();
    }
  }

  /**
   * 字节流方式写文件
   * @param append
   * @throws IOException
   */
  public static void writeByByteStream(boolean append) throws IOException {
    FileOutputStream fout=null;
    try {
      File file=new File("C:\\Users\\demo\\Desktop\\req-0260查余额.txt");
      fout=new FileOutputStream(file,true);
      fout.write("hello world!".getBytes());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      fout.close();
    }
  }
  public static void main(String[] args) throws IOException {

  }
}
