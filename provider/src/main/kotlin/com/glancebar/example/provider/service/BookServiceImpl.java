package com.glancebar.example.provider.service;


import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.BookService;
import org.apache.dubbo.config.annotation.DubboService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author YISHEN CAI
 */
@DubboService(version = "0.0.1", group = "example", validation = "true")
public class BookServiceImpl implements BookService {

    @Override
    public List<BookDTO> searchByMatch(@NotNull String keyword) {
        return null;
    }

    @Override
    public boolean addBook(@NotNull BookDTO bookDTO) {
        return false;
    }
}
