package com.example.dataservice.bean.model.part2.qiaojie;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/12/01 0:06
 */
public class Main {
    public static void main(String[] args) {
        Implementor implementor=new ConcreteImplementorA();
        Abstraction abstraction=new RefinedAbstraction(implementor);
        abstraction.Operation();
    }
}
