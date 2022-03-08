package com.example.dataservice.bean.model.part1.p3;

/**
 * @author: zhaosp1
 * @description: 简单工厂创建模式（灵活性）
 * @solution: 编程思想(通过参数来动态创建对应的对象)
 * @version: 1.0
 * @createDate: 2021/11/24 0:24
 */
public class SimpleFactory {
    private enum ProductType {
        PRODUCT_A,PRODUCT_B
    };
    public static Product getProduct(ProductType productType){
        switch (productType){
            case PRODUCT_A:
                return new ProductA();
            case PRODUCT_B:
                return new ProductB();
        }
        return null;
    }
    public static void main(String[] args) {
        getProduct(ProductType.PRODUCT_A);
    }
}
