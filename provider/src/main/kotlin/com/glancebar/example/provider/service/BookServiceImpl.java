package com.glancebar.example.provider.service;


import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.BookService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author YISHEN CAI
 */
public class BookServiceImpl implements BookService {

    @Override
    public List<BookDTO> searchByMatch(@NotNull String keyword) {
        return null;
    }

}
