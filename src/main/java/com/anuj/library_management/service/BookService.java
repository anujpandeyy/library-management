package com.anuj.library_management.service;

import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book createBook(CreateBookRequest createBookRequest);
    Book getBookById(UUID uuid);
    List<Book> getAllBooks();
}
