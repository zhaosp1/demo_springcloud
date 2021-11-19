package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ7 取近似值
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 14:03
 */
public class HJ7 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            double temp=sin.nextDouble();
            System.out.println((int)(temp+0.5));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
