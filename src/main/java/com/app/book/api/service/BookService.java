package com.app.book.api.service;

import com.app.book.api.domain.dto.Book;

import java.util.List;

public interface BookService {
    List<Book> findBooks();

    int findByBookCnt(Book dto);

    int insertBook(Book dto);

    Book findByBook(Book dto);

    int updateBook(Book dto);

    int deleteBook(int bookNo);
}
