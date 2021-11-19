package com.example.utilservice.util.algorithm.huawei;

import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: zhaosp1
 * @description: HJ10 字符个数统计
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/10/31 15:16
 */
public class HJ10 {
    public static void main(String[] args) {
        try (Scanner sin = new Scanner(System.in)) {
            char[] temp=sin.nextLine().toLowerCase(Locale.ROOT).toCharArray();
            Set set=new TreeSet();
            for(char c:temp)set.add(c);
            System.out.println(set.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
