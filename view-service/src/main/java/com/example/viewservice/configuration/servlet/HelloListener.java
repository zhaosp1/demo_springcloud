package com.example.viewservice.configuration.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * @author: zhaosp1
 * @description: springboot集成listener
 * @version: 1.0
 * @createDate: 2021/09/22 23:52
 */
@WebListener
public class HelloListener  implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContext对象消耗了");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("ServletContext对象创建了");
    }

}