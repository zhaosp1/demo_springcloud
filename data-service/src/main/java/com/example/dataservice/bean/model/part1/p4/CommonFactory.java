package com.example.dataservice.bean.model.part1.p4;

/**
 * @author: zhaosp1
 * @description: 简单工厂创建模式（灵活性）
 * @solution: 编程思想(通过参数来动态创建对应的对象)
 * @version: 1.0
 * @createDate: 2021/11/24 0:24
 */
public class CommonFactory {
    public static void main(String[] args) {
        IFactory factory=new FactoryA();
        IProduct product=factory.newProduct();

        IFactory1 factory1=new FactoryC();
        IProduct product1=factory1.newProduct(factory);
    }
}
