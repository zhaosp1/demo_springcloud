package com.example.dataservice.bean.model.part1.p4;

/**
 * @author: zhaosp1
 * @description: 实体工厂类A
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:35
 */
public class FactoryA implements IFactory{
    @Override
    public IProduct newProduct() {
        return new ProductA();
    }
}
