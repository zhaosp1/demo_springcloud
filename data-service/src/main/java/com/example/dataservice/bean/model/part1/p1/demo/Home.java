package com.example.dataservice.bean.model.part1.p1.demo;

/**
 * @author: zhaosp1
 * @description: 创建一个单例实例——家
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 22:56
 */
public class Home extends BaseEntity{
    private static Home home=new Home();

    private Home(){
    }

    public static Home getInstance(){
        return home;
    }
}
