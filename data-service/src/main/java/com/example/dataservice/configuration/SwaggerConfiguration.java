//package com.example.dataservice.configuration;
//
//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @Description  Swagger文档
// * @Author thcoding
// * @Date 2019/5/23
// **/
//@Configuration
//@EnableSwaggerBootstrapUI
//public class SwaggerConfiguration {
//
//
//  @Bean
//  public Docket createRestApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//      .apiInfo(apiInfo())
//      .select()
//      .apis(RequestHandlerSelectors.basePackage("com.example.dataservice.controller"))
//      .paths(PathSelectors.any())
//      .build();
//  }
//
//
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//      .title("zhaosp1接口管理文档")
//      .description("zhaosp1接口管理文档")
//      .termsOfServiceUrl("http://127.0.0.1:8031/")
//      .contact(new Contact("luck dog","","battle@qq.com"))
//      .version("1.0")
//      .build();
//  }
//
//}