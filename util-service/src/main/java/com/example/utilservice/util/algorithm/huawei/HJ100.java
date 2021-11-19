package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ100 等差数列
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 15:40
 */
public class HJ100 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
           while(sin.hasNext()){
               int temp=sin.nextInt();
               int result=2*temp+(temp*temp-temp)*3/2;
               System.out.println(result);
           }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
