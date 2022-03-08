package com.example.dataservice.bean.model.part2.daili;

import java.util.Objects;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/30 22:57
 */
public class ProxySubject implements Subject{
    private Subject subject;
    public ProxySubject(){
    }
    public ProxySubject(String type){
        if(Objects.equals("subject1",type)){
            subject=new RealSubject1();
        }
        if(Objects.equals("subject2",type)){
            subject=new RealSubject1();
        }
    }
    @Override
    public void doWork() {
        preWork();
        subject.doWork();
        postWork();
    }

    public void preWork() {
        System.out.println("执行真实任务之前的预处理...");
    }
    public void postWork() {
        System.out.println("执行真实任务之后的后续处理...");
    }

}
