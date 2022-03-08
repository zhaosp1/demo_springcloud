package com.example.dataservice.bean.model.part1.p2;

/**
 * @author: zhaosp1
 * @description: 原型模式
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:16
 */
public class Realizetype implements Cloneable {
    Realizetype() {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}