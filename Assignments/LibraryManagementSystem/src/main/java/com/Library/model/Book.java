package com.Library.model;

import com.Library.enums.Genre;
import com.Library.enums.Status;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "borrowed_by")
    private Member borrowedBy;

    @Column(name = "publishedYear")
    private int publishedYear;

    public Book() {
    }

    public Book(String title, Genre genre, Status status, int publishedYear) {
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.publishedYear = publishedYear;
    }

    public Book(String title, Genre genre, Status status, Author author, Member borrowedBy, int publishedYear) {
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.author = author;
        this.borrowedBy = borrowedBy;
        this.publishedYear = publishedYear;
    }

    public Book(long id, String title, Genre genre, Status status, Author author, Member borrowedBy, int publishedYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.author = author;
        this.borrowedBy = borrowedBy;
        this.publishedYear = publishedYear;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", status=" + status +
                ", author=" + author +
                ", borrowedBy=" + borrowedBy +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
