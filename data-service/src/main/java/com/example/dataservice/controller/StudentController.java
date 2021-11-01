package com.example.dataservice.controller;

import com.example.dataservice.bean.entity.Student;
import com.example.dataservice.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {
  @Autowired
  private StudentDao studentDao;

  /**
   * 用户列表展示
   */
  @RequestMapping("/list")
  @ResponseBody
  public List<Student> list(){
    List<Student> list = studentDao.findAll();
    return list;
  }
}
