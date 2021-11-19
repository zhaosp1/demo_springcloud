package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ11 数字颠倒
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 15:04
 */
public class HJ11 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            String temp=new StringBuilder(sin.nextLine()).reverse().toString();
            System.out.println(temp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
