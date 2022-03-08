package com.example.dataservice.bean.model.part1.p1.demo;

/**
 * @author: zhaosp1
 * @description: 测试类
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 23:14
 */
public class Main {
    public static void main(String[] args) {
        Home home=Home.getInstance();
        home.setDesc("这是一个单例模式测试类！");
        System.out.println(home.getDesc());

        Home home1=Home.getInstance();
        System.out.println(home.getDesc());
        home1.setDesc("修改后的测试类信息");
        System.out.println(home.getDesc());
        System.out.println(home1.getDesc());
    }
}
