package com.glancebar.example.api.service;

import com.glancebar.example.api.dto.BookDTO;

import java.util.List;

/**
 * @author YISHEN CAI
 */
public interface BookService {

    List<BookDTO> searchByMatch(String kw);
}
