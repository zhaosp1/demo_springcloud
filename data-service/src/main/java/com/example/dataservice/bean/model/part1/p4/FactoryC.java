package com.example.dataservice.bean.model.part1.p4;

/**
 * @author: zhaosp1
 * @description: 抽象工厂模式的实现
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:45
 */
public class FactoryC implements IFactory1{
    @Override
    public IProduct newProduct() {
        return new ProductB();
    }

    @Override
    public IProduct newProduct(IFactory factory) {
        return factory.newProduct();
    }
}
