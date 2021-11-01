package com.example.dataservice.repository;

import com.example.dataservice.bean.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CustomerDao {
    /**
     * 查询所有用户
     */
    List<Customer> findAll();
}