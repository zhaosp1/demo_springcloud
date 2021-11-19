package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ15 求int型正整数在内存中存储时1的个数
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 14:08
 */
public class HJ15 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            int temp=sin.nextInt();
            int num=0;
            while(temp/2!=0||temp%2!=0){
                if(temp%2!=0){
                    num+=1;
                }
                temp=temp/2;
            }

            System.out.println(num);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
