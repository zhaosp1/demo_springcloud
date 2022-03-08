package com.example.dataservice.bean.model.part1.p1;

/**
 * @author: zhaosp1
 * @description: 单例模式——饿汉式
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:11
 */
public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();

    private HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
