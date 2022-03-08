package com.example.dataservice.bean.model.part2.shipeiqi;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/30 23:53
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}
