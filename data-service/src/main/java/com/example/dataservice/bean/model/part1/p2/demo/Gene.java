package com.example.dataservice.bean.model.part1.p2.demo;

import java.io.Serializable;

/**
 * @author: zhaosp1
 * @description: 基因对象——用于区别深浅克隆
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/25 23:46
 */
public class Gene implements Serializable {
    private String type;
    public Gene(String type){
        this.type=type;
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Gene{" +
                "type='" + type + '\'' +
                '}';
    }
}
