package com.example.viewservice.configuration;

import com.example.viewservice.configuration.servlet.HelloFilter;
import com.example.viewservice.configuration.servlet.HelloListener;
import com.example.viewservice.configuration.servlet.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhaosp1
 * @description: springboot集成jsp的servlet、filter、listener,通过注解方式来进行配置
 * @version: 1.0
 * @createDate: 2021/09/22 23:56
 */
@Configuration
public class ServletConfig {
    //注册Servlet程序
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet());
        //设置访问路径
        bean.addUrlMappings("/helloServlet1");
        return bean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new HelloFilter());
        //过滤器拦截路径
        bean.addUrlPatterns("/helloServlet1");
        return bean;
    }

    //注册Listener
    @Bean
    public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<HelloListener> bean = new ServletListenerRegistrationBean<HelloListener>(new HelloListener());
        return bean;
    }
}

