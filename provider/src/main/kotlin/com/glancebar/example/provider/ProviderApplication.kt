package com.glancebar.example.provider

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@ImportResource(
    value = [
        "classpath:dubbo/dubbo-provider.xml"
    ]
)
@DubboComponentScan(basePackages = ["com.glancebar.example.provider.service"])
class ProviderApplication

fun main(args: Array<String>) {
    runApplication<ProviderApplication>(*args)
}
