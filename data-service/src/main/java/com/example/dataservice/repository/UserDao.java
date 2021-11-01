package com.example.dataservice.repository;

import com.example.dataservice.bean.entity.Student;
import com.example.dataservice.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: zhaosp1
 * @description:
 * @version: 1.0
 * @createDate: 2021/10/04 17:02
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
   User findByNameAndPassword(String userName,String passWord);
}
