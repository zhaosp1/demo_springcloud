package com.example.utilservice.battle.basal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: 练习（how2j）
 * @function：NioUtil工具类
 * @author: zhaosp1
 * @date: 2021/8/20 12:48
 **/
public class NioUtil {
  /**
   * nio实现文件复制
   *
   * @param from
   * @param to
   * @throws IOException
   */
  public static final void nioCopyFile(File from, File to) throws IOException {
    FileInputStream fin = null;
    FileOutputStream fout = null;
    FileChannel fic = null;
    FileChannel foc = null;
    try {
      fin = new FileInputStream(from);
      fout = new FileOutputStream(to);
      fic = fin.getChannel();
      foc = fout.getChannel();
      ByteBuffer bb = ByteBuffer.allocate(1024 << 4);
      while (fic.read(bb) > 0) {
        bb.flip();
        foc.write(bb);
        bb.clear();
      }
    } finally {
      if (null != fic)
        fic.close();
      if (null != foc)
        foc.close();
      if (null != fin)
        fin.close();
      if (null != fout)
        fout.close();
    }
  }

  /**
   * 通过通道实现文件的复制
   * @param from
   * @param to
   * @return
   * @throws IOException
   */
  public static boolean nioCopyFile(String from, String to) throws IOException {
    try(FileInputStream fin=new FileInputStream(from);
        FileOutputStream fout=new FileOutputStream(to);
        FileChannel cin=fin.getChannel();
        FileChannel cout=fout.getChannel();) {
//      cout.transferFrom(cin,0,cin.size());
      cin.transferTo(0,cin.size(),cout);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    nioCopyFile("C:\\Users\\demo\\Desktop\\123.txt","C:\\Users\\demo\\Desktop\\222.txt");
  }
}
