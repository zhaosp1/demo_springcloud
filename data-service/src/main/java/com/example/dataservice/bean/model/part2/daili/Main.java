package com.example.dataservice.bean.model.part2.daili;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/30 23:00
 */
public class Main {
    public static void main(String[] args) {
        Subject proxy=new ProxySubject("subject1");
        proxy.doWork();
    }
}
