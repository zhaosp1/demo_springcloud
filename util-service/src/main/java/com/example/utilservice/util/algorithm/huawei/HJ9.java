package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ9 提取不重复的整数
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 14:27
 */
public class HJ9 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            int temp=sin.nextInt();
            String t;
            StringBuilder sb=new StringBuilder();
            while(temp%10==0){
                temp=temp/10;
            }
            while(temp/10!=0||temp%10!=0){
                t=String.valueOf(temp%10);
                if(sb.indexOf(t)==-1){
                    sb.append(t);
                }
                temp=temp/10;
            }
            System.out.println(sb.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
