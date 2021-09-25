package com.glancebar.example.provider.service;


import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.BookService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

/**
 * 示例的简单实现
 *
 * @author YISHEN CAI
 */
@DubboService(version = "0.0.1", protocol = "dubbo", timeout = 3000)
public class BookServiceImpl implements BookService {

    @Override
    public List<BookDTO> searchByMatch(String keyword) {
        return Arrays.asList(new BookDTO("Book Name", "Book ISBN"));
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        return null;
    }

}
