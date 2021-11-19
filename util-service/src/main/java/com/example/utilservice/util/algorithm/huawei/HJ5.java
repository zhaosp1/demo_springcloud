package com.example.utilservice.util.algorithm.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: zhaosp1
 * @description: java进制之间的转换方法
 * @solution: 直接利用java的类函数进行求解
 * @version: 1.0
 * @createDate: 2021/10/31 13:53
 */
public class HJ5 {
    public static void main(String[] args) {
        try(BufferedReader sin=new BufferedReader(new InputStreamReader(System.in))){
            String temp;
            while((temp=sin.readLine())!=null){
                System.out.println(Integer.valueOf(temp.replace("0x",""),16));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
