package com.example.dataservice.bean.model.part1.p2.demo;

import com.example.dataservice.bean.model.part1.p1.demo.BaseEntity;

import java.io.*;

/**
 * @author: zhaosp1
 * @description: 原型模式——克隆羊
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 23:28
 */
public class Sheep extends BaseEntity implements Cloneable{
    private String name;
    private Gene gene;

    public Sheep(String name,Gene gene){
        this.name=name;
        this.gene=gene;
    }
    public void setName(String name){
        this.name=name;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }

    public void run(){
        System.out.println(this.name+"是一只"+this.gene.getType()+",它在奔跑着！");
    }

    protected Sheep shallowClone(){
        try{
            return (Sheep) super.clone();
        }catch (CloneNotSupportedException c){
            System.out.println(c.getMessage());
        }
        return null;
    }

    protected Sheep deepClone(){
        // TODO Auto-generated method stub
        Sheep sheep = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            sheep = (Sheep) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sheep;
    }
}
