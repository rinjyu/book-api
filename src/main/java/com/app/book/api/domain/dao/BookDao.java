package com.app.book.api.domain.dao;

import com.app.book.api.domain.dto.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {

    List<Book> selectBooks();

    int selectBookCnt(Book dto);

    Book selectBook(Book dto);

    int insertBook(Book dto);

    int updateBook(Book dto);

    int deleteBook(int bookNo);
}
