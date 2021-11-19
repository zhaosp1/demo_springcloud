package com.example.viewservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: zhaosp1
 * @description:
 * @solution: 编程思想()
 * @version: 1.0
 * @createDate: 2021/11/09 23:48
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //http://ip地址:端口/项目名/swagger-ui.html#/
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("API接口文档") //网站标题
                .description("赵书鹏的测试项目") //网站描述
                .version("9.0") //版本
                .contact(new Contact("赵书鹏","http://127.0.0.1:8080/demo?name=demo","464254690@qq.com")) //联系人
                .license("The Apache License") //协议
                .licenseUrl("http://www.baidu.com") //协议url
                .build();

        return new Docket(DocumentationType.SWAGGER_2) //swagger版本
                .pathMapping("/")
                .select()
                //扫描那些controller
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot20211109.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}
