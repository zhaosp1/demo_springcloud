package com.example.utilservice;

import com.example.utilservice.bean.pojo.Customer;
import com.example.utilservice.service.CustomerService;
import com.example.utilservice.service.MyTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilServiceApplicationTests {
  @Autowired
  private RedisTemplate redisTemplate;
  @Autowired
  public static MyTask myTask;
  @Test
  public void contextLoads() {
    System.out.println((Customer)redisTemplate.opsForValue().get("customer"));
  }


  @Autowired
  private CustomerService customerService;

  @Test
  public void test1(){
    //查询第一次
    System.out.println(customerService.findById(1));
    //查询第二次
    System.out.println(customerService.findById(1));
  }
  public static void main(String[] args) {
    myTask.task();
  }
}
