package com.example.dataservice.controller;

import com.example.dataservice.bean.entity.User;
import com.example.dataservice.repository.UserDao;
import com.example.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: zhaosp1
 * @description: 用户访问接口
 * @version: 1.0
 * @createDate: 2021/10/04 15:00
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/login")
    public String doLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        boolean flag=userService.doLogin(username,password);
        if(flag==true){
            return "welcome";
        }
        return "login";
    }

    @RequestMapping("/register")
    public String doRegister(){
        return "register";
    }

    @RequestMapping("/employment/usermanage")
    public String index(){
        return "system/usermanage/usermanage";
    }

    @PostMapping("/save")
    public String doCheck(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("age") String age,@RequestParam("sex") String sex){
        try{
            User user=User.builder().name(username).password(password).age(Integer.parseInt(age)).sex(sex).build();
            userService.save(user);
            return "redirect:login";
        }catch (Exception e){
            return "register";
        }
    }
}
