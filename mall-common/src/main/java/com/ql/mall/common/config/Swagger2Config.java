package com.ql.mall.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
@EnableSwagger2
@EnableOpenApi
@EnableWebMvc
@Configuration
public class Swagger2Config {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("mall项目在线接口文档")
                        .version("v1.0")
                        .description("mall项目接口文档")
                        .contact(new Contact("ql", "", "254693270@qq.com"))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ql.mall.admin.controller"))
                .build();
    }
}
