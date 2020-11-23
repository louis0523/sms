package com.huawei.sms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value(value = "${server.port}")
    private String serverPort;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huawei.sms.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        String host = "";
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            host = address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return new ApiInfoBuilder()
                .title("学生管理系统服务端接口")
                .description("sms：http://" + host + ":" + serverPort + "/rest/all.html\n" +
                        "WSDL接口文档：http://" + host + ":" + serverPort + "/rest/application.wadl")
                .termsOfServiceUrl("/rest/swagger-ui.html#/")
                .version("1.0.0")
                .build();
    }
}
