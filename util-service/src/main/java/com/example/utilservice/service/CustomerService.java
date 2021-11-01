package com.example.utilservice.service;

import com.example.utilservice.bean.pojo.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: zhaosp1
 * @description: spring整合Encache
 * @version: 1.0
 * @createDate: 2021/09/23 23:39
 */
@Service
public class CustomerService {

    @Cacheable(value = "customer",key = "#id")
    public Customer findById(Integer id){
        System.out.println("执行了UserService获取User");
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("小明");
        customer.setGender("男");
        customer.setTelephone("13244445555");
        return customer;
    }

}
