package com.glancebar.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author YISHEN CAI
 */
@SpringBootApplication
@ImportResource(value = { "classpath:dubbo/dubbo-consumer.xml" })
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
