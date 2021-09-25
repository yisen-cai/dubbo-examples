package com.glancebar.example.provider.service

import com.glancebar.example.api.service.DubboHealthService
import org.apache.dubbo.config.annotation.DubboService


/**
 *
 * @author YISHEN CAI
 */
@DubboService(version = "0.0.1")
class DubboHealthServiceImpl : DubboHealthService {
    override fun health(): String {
        return "health"
    }
}