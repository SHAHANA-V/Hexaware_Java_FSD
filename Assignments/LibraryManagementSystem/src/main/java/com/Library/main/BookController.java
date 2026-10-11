package com.Library.main;

import com.Library.config.AppConfig;
import com.Library.dto.BookRespDto;
import com.Library.enums.Genre;
import com.Library.enums.Status;
import com.Library.model.Book;
import com.Library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class BookController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = context.getBean(BookService.class);

/*
        String title=" Unbroken ";
        Genre genre= Genre.BIOGRAPHY;
        Status status = Status.BORROWED;
        long author_id = 2;
        int publishedYear =2026;
        long borrowedBy = 3;

        bookService.AddBook(title,genre,status,author_id,publishedYear,borrowedBy);
        System.out.println("Book Added to the Library");
*/

        System.out.println("Find Book By ID");
        long id = 3;
        Book book = bookService.findById(id);
        System.out.println(book);

        System.out.println("Find All Books");
        List<BookRespDto>list = bookService.findAllBooks();
        list.forEach(System.out::println);
    }
}
