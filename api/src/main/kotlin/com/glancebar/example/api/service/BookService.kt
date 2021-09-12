package com.glancebar.example.api.service

import com.glancebar.example.api.dto.BookDTO


/**
 *
 * @author YISHEN CAI
 */
interface BookService {
    fun searchByMatch(kw: String): List<BookDTO>
}