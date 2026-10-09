package com.Library.Repository;

import com.Library.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @PersistenceContext
    private  EntityManager entityManager;



    public void AddBook(Book book) {

        entityManager.persist(book);
    }

    public Optional<Book> findById(long id) {

        return Optional.ofNullable(entityManager.find(Book.class,id));
    }

    public List<Book> findAllBooks() {

        String jpql = "select b from Book b";
        return entityManager.createQuery(jpql, Book.class).getResultList();
    }
}
