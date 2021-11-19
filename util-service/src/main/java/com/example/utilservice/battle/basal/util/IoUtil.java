package com.example.utilservice.battle.basal.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：IoUtil工具类
 * @date 2021/8/19 0:17
 */
public class IoUtil {
  /**
   * 将base64字符解码保存文件（通过指定文件路径）
   * @param base64Code
   * @param path
   * @throws Exception
   */
  public static void decodeBase64(String base64Code,String path) throws Exception {
    byte[] buffer = new Base64().decodeBase64(base64Code);
    try(FileOutputStream fout = new FileOutputStream(path);){
      fout.write(buffer);
    }
  }

  /**
   * 将base64字符解码保存文件
   * @param base64Code
   * @param file
   * @throws Exception
   */
  public static void decodeBase64(String base64Code,File file) throws Exception {
    byte[] buffer = new Base64().decodeBase64(base64Code);
    try(FileOutputStream fout = new FileOutputStream(file);){
      fout.write(buffer);
    }
  }

  /**
   * 将文件字节流编码为base64字符串
   * @param path
   * @param charsetName
   * @return
   * @throws Exception
   */
  public static String Base64FileToBase64(String path,String charsetName) throws Exception {
    File file=new File(path);
    return new String(encodeBase64(file),charsetName);
  }

  /**
   * 将文件转成base64字节数组（通过指定文件路径）
   * @param path 文件路径
   * @return
   * @throws Exception
   */
  public static byte[] encodeBase64(String path) throws Exception {
    File  file = new File(path);
    return encodeBase64(file);
  }
  /**
   * 将文件转成base64字节数组
   * @param file 待编码文件
   * @return
   * @throws Exception
   */
  public static byte[] encodeBase64(File file) throws Exception {
    FileInputStream inputFile = new FileInputStream(file);
    byte[] buffer = new byte[(int)file.length()];
    inputFile.read(buffer);
    inputFile.close();
    return new Base64().encode(buffer);
  }

  /**
   * 将指定文件转换为字节流数组
   * @param fileName
   * @return
   * @throws Exception
   */
  public static byte[] file2Bytes(String fileName) throws Exception{
    try(FileInputStream fin=new FileInputStream(new File(fileName));){
      byte[] bytes=new byte[fin.available()];
      fin.read(bytes);
      return bytes;
    }
  }

  /**
   * 将字节数组转换为文件
   * @param bytes
   * @param fileName
   * @throws Exception
   */
  public static void bytes2File(byte[] bytes,String fileName) throws Exception{
    try(FileOutputStream fout=new FileOutputStream(new File(fileName));){
     fout.write(bytes);
    }
  }

  /**
   * 实现文件的复制
   * @param srcFile
   * @param descFile
   * @throws Exception
   */
  public static void copyFile(String srcFile,String descFile) throws Exception{
    bytes2File(file2Bytes(srcFile),descFile);
  }

  /**
   * 自定义重编码
   * @param bytes
   * @return
   */
  public static String recoding(byte[] bytes){
    StringBuilder sb=new StringBuilder();
    int flag=0;
    for(byte t:bytes){
      sb.append(String.format("%08d\t",t));
      flag++;
      if(flag==4) {
        flag=0;
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * 自定义解码
   * @param coding
   * @return
   */
  public static byte[] decoding(String coding){
    String[] sarray=coding.split("\\s+");
    byte[] bytes=new byte[sarray.length];
    for(int i=0;i<sarray.length;i++){
      bytes[i]=Byte.parseByte(sarray[i]);
    }
    return  bytes;
  }


  /**
   * 根据文件名获取父级文件
   *
   * @param fileName
   * @return
   */
  public static String getParent(String fileName) {
    File file = FileUtil.file(fileName);
    return getParent(file);
  }

  /**
   * 根据文件对象获取文件
   *
   * @param file
   * @return
   */
  public static String getParent(File file) {
    if (file.getParent() != null) {
      return file.getParent();
    } else {
      return null;
    }
  }

  /**
   * 根据文件名获取子文件数组
   *
   * @param fileName
   * @return
   */
  public static String[] getChild(String fileName) {
    File file = FileUtil.file(fileName);
    return getChild(file);
  }

  /**
   * 根据文件对象获取子文件数组
   *
   * @param file
   * @return
   */
  public static String[] getChild(File file) {
    if (file.isDirectory()) {
      return file.list();
    } else {
      return null;
    }
  }

  /**
   * 根据文件对象获取子文件数组
   *
   * @param file
   * @return
   */
  public static File[] getChildFile(File file) {
    if (file.isDirectory()) {
      return file.listFiles();
    } else {
      return null;
    }
  }

  public static void main(String[] args) throws Exception{
//    System.out.println(recoding(file2Bytes("C:\\Users\\demo\\Desktop\\123.txt")));
//    bytes2File(decoding(recoding(file2Bytes("C:\\Users\\demo\\Desktop\\报文.txt"))),"C:\\Users\\demo\\Desktop\\321.txt");
//    new FileWriter("C:\\Users\\demo\\Desktop\\123.txt").write(recoding(file2Bytes("C:\\Users\\demo\\Desktop\\报文.txt")));

    String temp = "C:\\Users\\demo\\Desktop\\docker-compose.yml";
    File file = FileUtil.file(temp);
    System.out.println("文件名为：" + file.getName() + "的父级菜单为" + getParent(file));
    System.out.printf("文件名为：%s的同级别文件有%d个:%n", file.getName(), getChild(getParent(file)).length);
    Arrays.stream(getChildFile(FileUtil.file(file.getParent()))).forEach(e -> System.out
      .println(
        e.getName() + "\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(e.lastModified()) + "\t\t" +
          (e.isDirectory() == true ?
            "文件夹" :
            e.getName().substring(e.getName().lastIndexOf('.') + 1) + "文件")));
  }
}
