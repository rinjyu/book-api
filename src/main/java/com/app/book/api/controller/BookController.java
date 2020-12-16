package com.app.book.api.controller;

import com.app.book.api.common.code.ErrorCode;
import com.app.book.api.common.code.SuccessCode;
import com.app.book.api.common.exception.ApiException;
import com.app.book.api.common.exception.DataNotFoundException;
import com.app.book.api.common.exception.DuplicateDataException;
import com.app.book.api.common.exception.InvalidFieldException;
import com.app.book.api.common.response.ApiSuccess;
import com.app.book.api.domain.dto.Book;
import com.app.book.api.service.BookService;
import com.app.book.api.validate.BookValidate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookValidate bookValidate;

    /**
     * Book 목록 조회
     * @return
     */
    @GetMapping(path = "/api/books")
    public ApiSuccess<List<Book>> getBooks() {

        List<Book> list = bookService.findBooks();

        ApiSuccess result = new ApiSuccess();
        result.setData(list);

        return result;
    }

    /**
     * Book 상세 조회
     * @return
     */
    @GetMapping(path = "/api/book/{bookNo}")
    public ApiSuccess<Book> getBook(@PathVariable int bookNo) {

        Book dto = new Book();
        dto.setBookNo(bookNo);

        int saveCnt = bookService.findByBookCnt(dto);
        if(saveCnt < 1) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "등록되지 않은 데이터입니다.");
        }

        Book detail = bookService.findByBook(dto);

        ApiSuccess result = new ApiSuccess();
        result.setData(detail);

        return result;
    }

    /**
     * Book 등록
     * @param dto
     * @param bindingResult
     * @return
     */
    @PostMapping("/api/books")
    public ApiSuccess<Book> insertBook(@RequestBody Book dto, BindingResult bindingResult) {

        bookValidate.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new InvalidFieldException(bindingResult.getFieldErrors());
        }

        int saveCnt = bookService.findByBookCnt(dto);
        if(saveCnt > 0) {
            throw new DuplicateDataException(ErrorCode.DUPLICATE_DATA.getCode(), "이미 등록되어 있습니다.");
        }

        int cnt = bookService.insertBook(dto);
        Book book;
        if (cnt > 0) {
            book = bookService.findByBook(dto);
        } else {
            throw new ApiException(ErrorCode.UNKNOWN_ERROR.getCode(), "등록 중 오류가 발생했습니다.");
        }

        ApiSuccess result = new ApiSuccess(SuccessCode.INSERT);
        result.setData(book);

        return result;
    }

    /**
     * Book 수정
     * @param dto
     * @param bindingResult
     * @return
     */
    @PatchMapping("/api/book/{bookNo}")
    public ApiSuccess<Book> updateBook(@RequestBody Book dto, BindingResult bindingResult) {

        bookValidate.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new InvalidFieldException(bindingResult.getFieldErrors());
        }

        int saveCnt = bookService.findByBookCnt(dto);
        if(saveCnt < 1) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "등록되지 않은 데이터입니다.");
        }

        int cnt = bookService.updateBook(dto);
        Book book;
        if (cnt > 0) {
            book = bookService.findByBook(dto);
        } else {
            throw new ApiException(ErrorCode.UNKNOWN_ERROR.getCode(), "수정 중 오류가 발생했습니다.");
        }

        ApiSuccess result = new ApiSuccess(SuccessCode.INSERT);
        result.setData(book);

        return result;
    }

    /**
     * Book 삭제
     * @return
     */
    @DeleteMapping("/api/book/{bookNo}")
    public ApiSuccess<Book> deleteBook(@PathVariable int bookNo) {

        Book dto = new Book();
        dto.setBookNo(bookNo);

        int saveCnt = bookService.findByBookCnt(dto);
        if(saveCnt < 1) {
            throw new DataNotFoundException(ErrorCode.NOT_FOUND.getCode(), "등록되지 않은 데이터입니다.");
        }

        int cnt = bookService.deleteBook(bookNo);
        if (cnt < 1) {
            throw new ApiException(ErrorCode.UNKNOWN_ERROR.getCode(), "삭제 중 오류가 발생했습니다.");
        }

        ApiSuccess result = new ApiSuccess(SuccessCode.DELETE);

        return result;
    }
}
