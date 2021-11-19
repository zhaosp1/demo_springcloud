package com.example.utilservice.util.algorithm.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: zhaosp1
 * @description: HJ8 合并表记录
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/06 15:22
 */
public class HJ8 {
    public static void main(String[] args) {
        try(Scanner sin=new Scanner(System.in)){
            int num=Integer.valueOf(sin.nextLine());
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int i=0;i<num;i++){
                String[] temp=sin.nextLine().split("\\s+");
                map.put(Integer.valueOf(temp[0]),map.getOrDefault(temp[0],0)+Integer.valueOf(temp[1]));
            }
            map.keySet().forEach(key-> System.out.println(key.toString()+" "+map.get(key).toString()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
