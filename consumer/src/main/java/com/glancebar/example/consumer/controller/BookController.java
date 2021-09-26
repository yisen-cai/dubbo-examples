package com.glancebar.example.consumer.controller;

import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.BookService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author YISHEN CAI
 */
@RestController
@RequestMapping("/books")
public class BookController {
    /**
     * 通过注解引用
     */
    @DubboReference(version = "0.0.1")
    private BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String kw) {
        System.out.println("hello world");
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
}
