package com.example.viewservice.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author: zhaosp1
 * @description: 全局异常处理类
 * @version: 1.0
 * @createDate: 2021/09/22 23:21
 */
@Configuration
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                                         Exception e) {
        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同处理
        if(e instanceof Exception){
            mv.setViewName("error");
        }

        mv.addObject("error", e.toString());
        return mv;
    }

}