package com.example.viewservice.configuration.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author: zhaosp1
 * @description: springboot集成servlet
 * @version: 1.0
 * @createDate: 2021/09/22 23:51
 */
@WebServlet(name="helloServlet",urlPatterns="/helloServlet")
public class HelloServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了HelloServlet的doGet方法....");
    }

}