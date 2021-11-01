package com.example.dataservice.service.impl;

import com.example.dataservice.bean.entity.User;
import com.example.dataservice.repository.UserDao;
import com.example.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhaosp1
 * @description: 用户业务类
 * @version: 1.0
 * @createDate: 2021/10/05 10:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录校验
     * @param username
     * @param password
     * @return
     */
    public boolean doLogin(String username, String password) {
        User user = userDao.findByNameAndPassword(username, password);
        if (user == null) {
            return false;
        }
        return true;
    }

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<User> findAll(){
        return userDao.findAll();
    }


    public void save(User user){
        userDao.save(user);
    }

}
