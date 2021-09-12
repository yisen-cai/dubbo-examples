package com.glancebar.example.consumer.controller;

import com.glancebar.example.api.service.BookService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YISHEN CAI
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Reference(version = "0.0.1")
    private BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String kw) {
        return ResponseEntity.ok(bookService.searchByMatch(kw));
    }
}
