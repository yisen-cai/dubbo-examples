package com.glancebar.example.api.service;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    /**
     * 使用CompletableFuture实现
     * 
     * @param name
     * 
     * @return
     */
    CompletableFuture<String> sayHello(String name);

    String sayHelloAgain(String name);
}
