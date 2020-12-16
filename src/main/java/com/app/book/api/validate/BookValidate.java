package com.app.book.api.validate;

import com.app.book.api.domain.dto.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class BookValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Book book = Book.class.cast(object);
        if (StringUtils.isEmpty(book.getBookNm())) {
            errors.rejectValue("bookNm", "bookNm은 필수값입니다.");
        }
        if (StringUtils.isEmpty(book.getBookAuthor())) {
            errors.rejectValue("bookAuthor", "bookAuthor는 필수값입니다.");
        }
        if (StringUtils.isEmpty(book.getBookPublisher())) {
            errors.rejectValue("bookPublisher", "bookPublisher는 필수값입니다.");
        }
        if (book.getBookPrice() < 1) {
            errors.rejectValue("bookPrice", "bookPrice는 0보다 큰 값이어야 합니다.");
        }
        if (StringUtils.isEmpty(book.getBookDesc())) {
            errors.rejectValue("bookDesc", "bookDesc는 필수값입니다.");
        }
    }
}

