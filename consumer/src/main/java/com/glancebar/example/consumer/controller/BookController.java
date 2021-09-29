package com.glancebar.example.consumer.controller;

import java.util.concurrent.CompletableFuture;

import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.AsyncService;
import com.glancebar.example.api.service.BookService;
import com.glancebar.example.api.service.CallbackService;
import com.glancebar.example.api.service.IDemoService;
import com.glancebar.example.api.service.Person;
import com.glancebar.example.callback.Notify;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author YISHEN CAI
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    /**
     * 通过注解引用
     */
    @DubboReference(version = "0.0.1")
    private BookService bookService;

    @Autowired
    private Notify demoCallback;

    @DubboReference(version = "0.0.1", group = "cn", methods = {
            @Method(name = "get", async = false, onreturn = "demoCallback.onReturn", onthrow = "demoCallback.onThrow") })
    private IDemoService normalDemoService;

    @DubboReference(version = "0.0.1", methods = { @Method(name = "sayHelloAgain", async = true) }, timeout = 10000)
    private AsyncService asyncService;

    @DubboReference(version = "0.0.1")
    private CallbackService callbackService;

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String kw) {
        RpcContext.getContext().set("something", "some value");

        // 隐式参数
        RpcContext.getContext().setAttachment("index", "1");
        return ResponseEntity.ok(bookService.searchByMatch(kw));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateBook(@RequestBody BookDTO bookDTO) {
        try {
            return ResponseEntity.ok(bookService.addBook(bookDTO));
        } catch (Exception e) {
            // do something.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/async")
    public ResponseEntity<?> asyncInvoke(@RequestParam String param) {
        CompletableFuture<String> future = asyncService.sayHello(param);
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                logger.info("async result is " + v);
            }
        });
        return null;
    }

    @PostMapping("/async-again")
    public ResponseEntity<?> asyncInvokeAgain(@RequestParam String param) {
        asyncService.sayHelloAgain(param);
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                logger.info("async result is " + retValue);
            } else {
                exception.printStackTrace();
            }
        });

        // 另一种调用方式
        CompletableFuture<String> future = RpcContext.getContext().asyncCall(() -> {
            return asyncService.sayHelloAgain("oneway call request1");
        });

        future.whenComplete((retValue, exception) -> {
            if (exception == null) {
                logger.info("async result is " + retValue);
            } else {
                exception.printStackTrace();
            }
        });

        return null;
    }

    @PostMapping("/callback")
    public ResponseEntity<?> callbackService(@RequestParam String param) {
        callbackService.addListener(param, (msg) -> {
            logger.info("callback message is: ", msg);
        });
        return null;
    }

    @PostMapping("/callback-notify")
    public ResponseEntity<?> callbackNotify(@RequestParam Integer id) {
        Person person = normalDemoService.get(id);
        return ResponseEntity.ok(person);
    }
}
