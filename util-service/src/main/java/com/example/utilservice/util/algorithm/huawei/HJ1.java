package com.example.utilservice.util.algorithm.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: zhaosp1
 * @description: HJ1 字符串最后一个单词的长度
 * @sulotion:1、获取输入字符串——>2、根据空格分割为字符串数组——>3、取数组最后一个字符串元素的长度
 * @version: 1.0
 * @createDate: 2021/10/31 11:00
 */
public class HJ1 {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            String[] temp=br.readLine().split("\\s+");
            System.out.println(temp[temp.length-1].length());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
