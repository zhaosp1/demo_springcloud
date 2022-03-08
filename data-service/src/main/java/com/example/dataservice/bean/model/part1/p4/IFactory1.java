package com.example.dataservice.bean.model.part1.p4;

/**
 * 抽象工厂模式（工厂模式的升级）
 */
public interface IFactory1 extends IFactory{
    IProduct newProduct(IFactory factory);
}
