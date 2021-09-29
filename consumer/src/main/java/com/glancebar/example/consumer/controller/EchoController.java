package com.glancebar.example.consumer.controller;

import com.glancebar.example.api.service.BookService;

import org.apache.catalina.core.ApplicationContext;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @DubboReference(version = "0.0.1")
    private BookService bookService;

    @RequestMapping
    public ResponseEntity<?> echo(@RequestParam String service) {
        String status = (String) ((EchoService) bookService).$echo("OK");
        assert (status.equals("OK"));
        return null;
    }
}
