package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;

/**
 * @author: zhaosp1
 * @description: HJ12 字符串反转
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 15:14
 */
public class HJ12 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            System.out.println(new StringBuilder(sin.nextLine()).reverse());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
