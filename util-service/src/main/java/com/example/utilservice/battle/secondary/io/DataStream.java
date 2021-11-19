package com.example.utilservice.battle.secondary.io;

import java.io.*;

/**
 * @description: 练习（how2j）
 * @function：数据流的基本操作
 * @author: zhaosp1
 * @date: 2021/8/18 16:04
 **/
public class DataStream {

  //字节流文件读取
  public static void readByDataStream() throws IOException {
    FileInputStream fin=null;
    DataInputStream din=null;
    try {
      File file=new File("C:\\Users\\lucky\\Desktop\\phone.txt");
      fin=new FileInputStream(file);
      din=new DataInputStream(fin);
      String s=din.readLine();
      System.out.println(s);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      fin.close();
      din.close();
    }
  }


  //字节流方式写文件
  public static void writeByDataStream(boolean append) throws IOException {
    FileOutputStream fout=null;
    DataOutputStream dout=null;
    try {
      File file=new File("C:\\Users\\lucky\\Desktop\\phone.txt");
      fout=new FileOutputStream(file,true);
      dout=new DataOutputStream(fout);
      dout.writeFloat(12.5f);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      fout.close();
      dout.close();
    }
  }
  public static void main(String[] args) throws IOException {
    writeByDataStream(true);
    readByDataStream();
  }
}
