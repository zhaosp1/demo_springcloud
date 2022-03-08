package com.example.dataservice.bean.model.part1.p1;

/**
 * @author: zhaosp1
 * @description: 单例模式——懒汉式
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/24 0:06
 */
public class LazySingleton {
    //保证instance在所有的线程可见
    private static volatile LazySingleton instance=null;

    private LazySingleton(){
    }

    //保证instance在所有的线程唯一
    public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }
}
