package com.example.dataservice.repository;

import com.example.dataservice.bean.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Dao接口
 * 一点教程网 - www.yiidian.com
 */
public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>{
}