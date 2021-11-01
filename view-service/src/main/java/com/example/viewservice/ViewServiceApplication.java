package com.example.viewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
public class ViewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewServiceApplication.class, args);
    }

}
