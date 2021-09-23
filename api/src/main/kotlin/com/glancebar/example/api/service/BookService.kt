package com.glancebar.example.api.service

import com.glancebar.example.api.dto.BookDTO


/**
 * 一个接口示例
 * @author YISHEN CAI
 */
interface BookService {
    fun searchByMatch(kw: String): List<BookDTO>
}