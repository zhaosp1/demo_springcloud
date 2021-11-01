package com.example.utilservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableCaching // 开启缓存
@SpringBootApplication
public class UtilServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UtilServiceApplication.class, args);
  }

}
