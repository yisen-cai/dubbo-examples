package com.glancebar.example.api.service

import com.glancebar.example.api.dto.BookDTO
import javax.validation.GroupSequence


/**
 *
 * @author YISHEN CAI
 */
interface BookService {
    fun searchByMatch(kw: String): List<BookDTO>

    annotation class Save {
    }
    fun addBook(bookDTO: BookDTO): Boolean
}