package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: zhaosp1
 * @description: HJ13 句子逆序
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 15:06
 */
public class HJ13 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            String[] temp=sin.nextLine().split("\\s+");
            int len=temp.length;

            StringJoiner sb=new StringJoiner(" ");
            for(int i=len-1;i>=0;i--){
               sb.add(temp[i]);
            }
            System.out.println(sb.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
