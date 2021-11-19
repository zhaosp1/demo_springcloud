package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ6 质数因子
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/06 14:36
 */
public class HJ6 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            int num=sin.nextInt();
            int temp=num;
            StringBuilder sb=new StringBuilder();
            for(int i=2;i<=Math.sqrt(num);i++){
                while(num%i==0){
                    sb.append(i).append(" ");
                    num/=i;
                }
            }
            if(num!=1){
                sb.append(num);
            }
            System.out.println(sb.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
