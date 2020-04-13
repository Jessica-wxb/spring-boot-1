package com.dmsdbj.team.springbootdemo.config;

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
 * @author Jessica
 * @version 1.0.0
 * @ClassName Swagger2.java
 * @Description TODO
 * @createTime 2020年03月18日 10:33:00
 */
// 通过@Configuration 注解，让 Spring 加载该配置类。
@Configuration
// 再通过@EnableSwagger2注解来启用 Swagger2
@EnableSwagger2

public class Swagger2 {
    /**
     *成员方法 createRestApi 函数创建 Docket的Bean之后，apiInfo()用来创建该 Api的基本信息（这些信息会展现再文档页面中）。
     *
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用制定扫描的包路径来定义。
     * Swagger会扫描该包下所有Controller定义的API,并产生文档（除了被 @ApiIgnore指定的请求 ）
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 当前包的路径
                .apis(RequestHandlerSelectors.basePackage("com.dmsdbj.team.springbootdemo.controller"))
                // 刻意根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }
    // 构建api文档的详细信息函数，注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("pringboot 使用 swagger2 构建RESTful API")
                // 创建人
                .contact(new Contact("Jessica","https://blog.csdn.net/riemann_/article/details/103604132","18831645427@163.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }


}
