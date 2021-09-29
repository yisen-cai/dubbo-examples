package com.glancebar.example.provider.service;

import java.util.concurrent.CompletableFuture;

import com.glancebar.example.api.service.AsyncService;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

@DubboService(version = "0.0.1")
public class AsyncServiceImpl implements AsyncService {

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext savedContext = RpcContext.getContext();
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider.";
        });
    }

    @Override
    public String sayHelloAgain(String name) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            // 使用上下文
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            // 写回应
            asyncContext.write("Hello " + name + ", response from provider.");
        }).start();
        return null;
    }
    
}
