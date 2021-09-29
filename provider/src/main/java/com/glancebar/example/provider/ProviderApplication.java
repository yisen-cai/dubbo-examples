package com.glancebar.example.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * DubboComponentScan开启扫描注解组件
 *
 * @author YISHEN CAI
 */
@SpringBootApplication
@ImportResource(value = { "classpath:dubbo/dubbo-provider.xml" })
@DubboComponentScan(basePackages = { "com.glancebar.example.provider.service" })
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}
