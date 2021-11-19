package com.example.utilservice.util.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author: zhaosp1
 * @description: HJ14 字符串排序
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/06 12:22
 */
public class HJ14 {
    public static void main(String[] args) {
        try (Scanner sin = new Scanner(System.in)) {
            int size = Integer.valueOf(sin.nextLine());
            String[] temp = new String[size];
            for (int i = 0; i < size; i++) {
                temp[i] = sin.nextLine();
            }
            Arrays.sort(temp);
            StringJoiner sj=new StringJoiner("\n");
            for (String t : temp) {
                sj.add(t);
            }
            System.out.println(sj.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
