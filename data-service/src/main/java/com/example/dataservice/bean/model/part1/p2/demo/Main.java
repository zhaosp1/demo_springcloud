package com.example.dataservice.bean.model.part1.p2.demo;

/**
 * @author: zhaosp1
 * @description: 客户端调用实例
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 23:31
 */
public class Main {
    public static void main(String[] args) {
        Sheep sheep=new Sheep("Dolly",new Gene("绵羊"));
        sheep.run();

        /**
         * 深克隆示例——利用序列化与反序列化机制对原型进行深层克隆，但是效率太低
         */
        System.out.println("————————————深克隆示例————————————");
        Sheep sheep2= sheep.deepClone();
        sheep2.run();
        sheep2.setName("July");
        sheep2.getGene().setType("山羊");
        sheep2.run();
        sheep.run();


        /**
         * 浅克隆示例——对于基本数值类型的成员会新建副本，但对于引用类型（除了String等利用常量池的类型）的成员则只是新建引用，且该引用还是会指向原对象。
         * 因其浅克隆特性，浅克隆会存在引用对象安全的风险。
         */
        System.out.println("————————————浅克隆示例————————————");
        Sheep sheep1= sheep.shallowClone();
        sheep1.run();
        sheep1.setName("Tom");
        sheep1.getGene().setType("山羊");
        sheep1.run();
        sheep.run();



    }
}
