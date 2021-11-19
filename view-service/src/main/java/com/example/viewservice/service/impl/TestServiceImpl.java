package com.example.viewservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.viewservice.service.TestService;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/10 0:09
 */
@Service(version = "1.0.0",timeout = 3000)
public class TestServiceImpl implements TestService {

    @Override
    public void testDubbo() {
        System.out.println("dubbo测试！");
    }
}