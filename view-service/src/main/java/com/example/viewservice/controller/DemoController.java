package com.example.viewservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/09 23:42
 */
@Api(value = "测试控制类", tags = "测试控制类", description = "测试控制类描述")
@RestController("/")
public class DemoController {
    @ApiOperation(value = "测试方法", notes = "测试方法", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String")
    })
    @GetMapping("/demo")
    public String test(@RequestParam(value = "name", defaultValue = "小明同学") String name) {
        return "hello " + name + "!";
    }
}
