package com.example.viewservice.controller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author: zhaosp1
 * @description: 文件上传控制器
 * @version: 1.0
 * @createDate: 2021/09/22 22:54
 */
@RestController
public class UploadController {
    /*
     * 使用spring框架接收文件
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("attach")MultipartFile file) throws Exception{
        //处理文件
        System.out.println("文件原名称："+file.getOriginalFilename());
        System.out.println("文件类型："+file.getContentType());

        //保存到硬盘
        file.transferTo(new File("C:\\Users\\luck dog\\Desktop\\upload\\"+file.getOriginalFilename()));

        return "上传成功";
    }
}