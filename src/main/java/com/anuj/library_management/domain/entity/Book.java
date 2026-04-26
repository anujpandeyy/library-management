package com.anuj.library_management.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Book")
public class Book {
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author=" + author +
                ", published=" + published +
                ", pages=" + pages +
                '}';
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id",nullable = false,updatable = false)
    private UUID id;

    public Book(){

    }

    public Book(UUID id, String name, String ISBN, Author author, LocalDate published, int pages) {
        this.id = id;
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.published = published;
        this.pages = pages;
    }

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "isbn",nullable = false)
    private String ISBN;
    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private Author author;
    @Column(name = "published",nullable = false)
    private LocalDate published;
    @Column(name = "pages",nullable = false)
    private int pages;
}
