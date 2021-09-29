package com.glancebar.example.api.service;

import com.glancebar.commons.CommonHandling;
import com.glancebar.example.api.dto.BookDTO;

import java.util.List;

/**
 * 简单示例
 *
 * @author YISHEN CAI
 */
public interface BookService {

    /**
     * 关键字模糊搜索
     *
     * @param kw
     *            搜索关键字
     * 
     * @return book列表
     */
    List<BookDTO> searchByMatch(String kw);

    BookDTO addBook(BookDTO bookDTO);
}
