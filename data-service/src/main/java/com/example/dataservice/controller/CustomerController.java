package com.example.dataservice.controller;

import com.example.dataservice.bean.entity.Customer;
import com.example.dataservice.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: zhaosp1
 * @description:
 * @version: 1.0
 * @createDate: 2021/09/24 0:04
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 用户列表展示
     */
    @RequestMapping("/list/customer")
    @ResponseBody
    public List<Customer> list(){
        //模拟用户数据
        List<Customer> list = customerDao.findAll();
        return list;
    }
}