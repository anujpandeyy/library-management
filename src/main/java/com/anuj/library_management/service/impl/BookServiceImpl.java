package com.anuj.library_management.service.impl;

import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;
import com.anuj.library_management.exception.AuthorNotFoundException;
import com.anuj.library_management.exception.BookNotFoundException;
import com.anuj.library_management.mapper.BookMapper;
import com.anuj.library_management.repository.AuthorRepository;
import com.anuj.library_management.repository.BookRepository;
import com.anuj.library_management.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,BookMapper bookMapper, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;

    }

    @Override
    public Book createBook(CreateBookRequest createBookRequest) {
        Author author = authorRepository.findById(createBookRequest.author_id()).orElseThrow(()-> new AuthorNotFoundException(createBookRequest.author_id()));
        Book book = bookMapper.toEntity(createBookRequest,author);
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(UUID uuid) {
        return bookRepository.findById(uuid).orElseThrow(()-> new BookNotFoundException(uuid));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
