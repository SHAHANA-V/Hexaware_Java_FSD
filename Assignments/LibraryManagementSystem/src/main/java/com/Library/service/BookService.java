package com.Library.service;

import com.Library.Repository.AuthorRepository;
import com.Library.Repository.BookRepository;
import com.Library.Repository.MemberRepository;
import com.Library.dto.BookRespDto;
import com.Library.enums.Genre;
import com.Library.enums.Status;
import com.Library.exception.ResourceNotFoundException;
import com.Library.mapper.BookMapper;
import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Member;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void AddBook(String title, Genre genre, Status status, long authorId, int publishedYear, long borrowedBy) {
        //fetch the author
        Optional<Author> optional = authorRepository.getAuthorById(authorId);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Invalid Author id....");

        Author author = optional.get();

        //fetch the borrower
       Optional<Member> optionalMember= memberRepository.getMemberById(borrowedBy);
       if(optionalMember.isEmpty())
           throw new ResourceNotFoundException("Invalid Member id...");
       Member member = optionalMember.get();

        //create a book object
        Book book = new Book(title,genre,status,publishedYear);

        //attach author and member to book
        book.setAuthor(author);
        book.setBorrowedBy(member);

        bookRepository.AddBook(book);


    }

    public Book findById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty())
            throw new ResourceNotFoundException("Book not found");
        return optionalBook.get();
    }


    public List<BookRespDto> findAllBooks() {
        List<Book> list = bookRepository.findAllBooks();
        return list.stream().map(BookMapper::mapToBook).toList();
    }
}
