package com.example.dataservice.bean.model.part1.p3;

/**
 * @author: zhaosp1
 * @description: 产品实现类B
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:21
 */
public class ProductB implements Product{
    public ProductB(){
        show();
    }
    @Override
    public void show() {
        System.out.println("创建了产品B");
    }
}