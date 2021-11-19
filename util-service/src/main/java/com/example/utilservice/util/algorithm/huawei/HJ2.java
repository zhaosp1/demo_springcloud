package com.example.utilservice.util.algorithm.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @author: zhaosp1
 * @description: HJ2 计算某字母出现次数
 * @solution：1、获取输入字符串和目标值——>2、将字符串、目标值转换成统一的大小写——>3、循环湖区字符串中目标值出现的位置并记录出现的次数
 * @version: 1.0
 * @createDate: 2021/10/31 11:06
 */
public class HJ2 {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            String s=br.readLine().toLowerCase(Locale.ROOT);
            String key=br.readLine().toLowerCase(Locale.ROOT);
            if(s==null||key==null||"".equals(s)||"".equals(key)){
                System.out.println(0);
            }else {
                int count=0;
                int index=0;
                while((index=s.indexOf(key,index))!=-1){
                    index=index+key.length();
                    count+=1;
                }
                System.out.println(count);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
