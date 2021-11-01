package com.example.dataservice.service;

import com.example.dataservice.bean.entity.User;
import com.example.dataservice.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhaosp1
 * @description: 用户业务类
 * @version: 1.0
 * @createDate: 2021/10/05 10:40
 */
public interface UserService {

    /**
     * 登录校验
     * @param username
     * @param password
     * @return
     */
    public boolean doLogin(String username, String password);

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 保存对象
     * @param user
     */
    public void save(User user);

}
