package com.example.viewservice.controller;

import com.example.viewservice.bean.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
/**
 * @author: zhaosp1
 * @description: Spring Boot表单数据验证
 * @version: 1.0
 * @createDate: 2021/09/22 23:32
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跳转到add.html
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(User user){
        return "user/add";
    }

    /**
     * 用户添加
     * BindingResult: 用于封装验证对象（user）里面的验证结果
     */
    @RequestMapping("add")
    public String add(@Valid User user, BindingResult result){
        //如果存在验证错误
        if(result.hasErrors()){
            //返回add.html
            return "add";
        }

        System.out.println("保存用户:"+user);
        return "user/list";
    }
}