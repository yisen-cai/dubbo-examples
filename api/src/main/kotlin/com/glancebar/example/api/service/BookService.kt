package com.glancebar.example.api.service

import com.glancebar.example.api.dto.BookDTO
import com.glancebar.example.api.dto.ChapterDTO


/**
 *
 * @author YISHEN CAI
 */
interface BookService {

    /**
     * 模糊搜索书籍
     *
     * @param keyword 搜索关键字
     * @return
     */
    fun searchByMatch(keyword: String): List<BookDTO>

    /**
     * 列出书籍的章节
     *
     * @param bookId
     * @return
     */
    fun listBookChapter(bookId: Long): List<ChapterDTO>

    /**
     * 添加书籍章节
     *
     * @param bookId
     * @param chapters
     * @return
     */
    fun addBookChapter(bookId: Long, chapters: List<ChapterDTO>): Int

    /**
     *
     *
     * @param authorId
     * @return
     */
    fun listBooksByAuthor(authorId: Long): List<BookDTO>
}