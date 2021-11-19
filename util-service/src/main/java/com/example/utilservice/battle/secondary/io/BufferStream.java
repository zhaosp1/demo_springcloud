package com.example.utilservice.battle.secondary.io;

import java.io.*;

/**
 * @description: 练习（how2j）
 * @function：缓存流的基本操作
 * @author: zhaosp1
 * @date: 2021/8/18 16:04
 **/
public class BufferStream {
  /**
   * 缓存字符输入流 BufferedReader 可以一次读取一行数据
   * @throws IOException
   */
  public static void readByBufferStream() throws IOException {
    BufferedReader fin=null;
    try {
      File file=new File("C:\\Users\\lucky\\Desktop\\phone.txt");
      fin=new BufferedReader(new FileReader(file));
      char[] temp=new char[1024];
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


  //PrintWriter 缓存字符输出流， 可以一次写出一行数据

  /**
   * 有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
   * @param append
   * @throws IOException
   */
  public static void writeByBufferStream(boolean append) throws IOException {
    PrintWriter fout=null;
    try {
      File file=new File("C:\\Users\\lucky\\Desktop\\phone.txt");
      fout=new PrintWriter(new FileWriter(file),true);
      fout.println("hello world");
      fout.flush();
      fout.println("ni hao!");
      fout.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      fout.close();
    }
  }
  public static void main(String[] args) throws IOException {
    writeByBufferStream(true);
    readByBufferStream();
  }
}
