package com.example.utilservice.util.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: zhaosp1
 * @description: 明明的随机数，随机生成n组数，并进行去重、排序
 * @solution: 1、利用TreeSet数据结构接收输入对象——>2、每组数值输入完成后进行输出(也可以使用标记法，通过数组来进行求值）
 * @version: 1.0
 * @createDate: 2021/10/31 11:51
 */
public class HJ3 {
    public static void main(String[] args) {
        int[] array=new int[1001];
        Arrays.fill(array,0);

        try (Scanner sin = new Scanner(System.in)) {
            while (sin.hasNext()) {

                Set<Integer> set = new TreeSet<Integer>();
                int temp=sin.nextInt();
                for (int i = 0; i < temp; i++) {
                    array[sin.nextInt()]=1;
                }
                for(int i=0;i<1001;i++){
                    if(array[i]==1){
                        System.out.println(i);
                    }
                }
                Arrays.fill(array,0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
