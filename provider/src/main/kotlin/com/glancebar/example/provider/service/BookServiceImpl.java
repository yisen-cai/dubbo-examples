package com.glancebar.example.provider.service;

import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.dto.ChapterDTO;
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


    @Override
    public List<ChapterDTO> listBookChapter(long bookId) {
        return null;
    }

    @Override
    public int addBookChapter(long bookId, @NotNull List<ChapterDTO> chapters) {
        return 0;
    }


    @Override
    public List<BookDTO> listBooksByAuthor(long authorId) {
        return null;
    }
}
