package com.example.utilservice.battle.secondary.io;

import java.io.*;

/**
 * @description: 练习（how2j）
 * @function：对象流基本操作
 * @author: zhaosp1
 * @date: 2021/8/18 16:25
 **/
public class ObjectStream {
  //把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
  static class Hero implements Serializable {
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;
  }

  /**
   * 对象流方式写文件
   * @throws IOException
   */
  public static void writeByObjectStream() throws IOException {
    Hero hero = new Hero();
    hero.name = "garen";
    hero.hp = 616;
    try (FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\lucky\\Desktop\\phone.txt"));
         ObjectOutputStream oos = new ObjectOutputStream(fos);) {
      oos.writeObject(hero);
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  /**
   * 对象流方式读取文件
   * @throws IOException
   */
  public static void readByObjectStream() throws IOException {
    try (FileInputStream fin = new FileInputStream(new File("C:\\Users\\lucky\\Desktop\\phone.txt"));
         ObjectInputStream oin = new ObjectInputStream(fin);) {
      Hero hero=(Hero)oin.readObject();
      System.out.println(hero.hp+"\t"+hero.name);
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    writeByObjectStream();
    readByObjectStream();
  }
}
