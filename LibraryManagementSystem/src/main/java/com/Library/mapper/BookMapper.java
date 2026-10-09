package com.Library.mapper;

import com.Library.dto.BookRespDto;
import com.Library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public static BookRespDto mapToBook(Book book){
        return new BookRespDto(
                book.getTitle(),
                book.getGenre(),
                book.getStatus(),
                book.getPublishedYear(),
                book.getAuthor()==null?null : book.getAuthor().getName(),
                book.getBorrowedBy()==null?null :book.getBorrowedBy().getName(),
                book.getBorrowedBy()==null?null :book.getBorrowedBy().getEmail(),
                book.getBorrowedBy()==null?null :book.getBorrowedBy().getMembershipType()
        );

    }
}
