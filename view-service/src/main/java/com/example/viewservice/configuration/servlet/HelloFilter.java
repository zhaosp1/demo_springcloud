package com.example.viewservice.configuration.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * @author: zhaosp1
 * @description: springboot集成filter
 * @version: 1.0
 * @createDate: 2021/09/22 23:52
 */
@WebFilter(filterName="helloFilter",urlPatterns="/helloServlet")
public class HelloFilter implements Filter{

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        System.out.println("执行了前面代码");

        //放行执行目标资源：HelloServlet
        arg2.doFilter(arg0, arg1);

        System.out.println("执行了后面代码");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}