package com.app.book.api.service.impl;

import com.app.book.api.domain.dao.BookDao;
import com.app.book.api.domain.dto.Book;
import com.app.book.api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Override
    public List<Book> findBooks() {
        return bookDao.selectBooks();
    }

    @Override
    public int findByBookCnt(Book dto) {
        return bookDao.selectBookCnt(dto);
    }

    @Override
    public int insertBook(Book dto) {
        return bookDao.insertBook(dto);
    }

    @Override
    public Book findByBook(Book dto) {
        return bookDao.selectBook(dto);
    }

    @Override
    public int updateBook(Book dto) {
        return bookDao.updateBook(dto);
    }

    @Override
    public int deleteBook(int bookNo) {
        return bookDao.deleteBook(bookNo);
    }
}
