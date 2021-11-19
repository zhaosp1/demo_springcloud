package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ4 字符串分隔，每8位输出，不足补零
 * @solution: 1、获取字符串输入——>2、将字符串每8位进行输出，不足8位则进行补0输出
 * @version: 1.0
 * @createDate: 2021/10/31 13:06
 */
public class HJ4 {
    public static void main(String[] args) {
       try(Scanner sin=new Scanner(System.in)){
           while (sin.hasNext()){
               String temp=sin.nextLine().replaceAll("\\s+","");
               int len=temp.length();
               int begin=0;
               int end=8;
               while(end<=len){
                   System.out.println(temp.substring(begin,end));
                   begin+=8;
                   end+=8;
               }
               int t=end-len;
               if(t>0&&t<8){
                   StringBuilder sb=new StringBuilder();
                   for(int i=0;i<t;i++){
                       sb.append("0");
                   }
                   System.out.println(temp.substring(begin,len)+sb.toString());
               }
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}
