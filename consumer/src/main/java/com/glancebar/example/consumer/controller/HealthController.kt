package com.glancebar.example.consumer.controller

import com.glancebar.example.api.service.DubboHealthService
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.RestController


/**
 *
 * @author YISHEN CAI
 */
@RestController
class HealthController {
    @DubboReference(version = "0.0.1")
    lateinit var dubboHealthService: DubboHealthService


}