package com.example.utilservice.battle.secondary.io;

import java.io.*;

/**
 * @description: 练习（how2j）
 * @function：字符流基本操作
 * @author: zhaosp1
 * @date: 2021/8/18 16:25
 **/
public class CharStream {
  /**
   * 字符流文件读取
   * @throws IOException
   */
  public static void readByCharStream() throws IOException {
    FileReader fin=null;
    try {
      File file=new File("C:\\Users\\demo\\Desktop\\req-0260查余额.txt");
      fin=new FileReader(file);
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

  /**
   * 字符流方式写文件
   * @param append
   * @throws IOException
   */
  public static void writeByCharStream(boolean append) throws IOException {
    FileWriter fout=null;
    try {
      File file=new File("C:\\Users\\demo\\Desktop\\req-0260查余额.txt");
      fout=new FileWriter(file,true);
      fout.write("\nhello world!");
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
