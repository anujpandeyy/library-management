package com.anuj.library_management.controller;

import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.UpdateBookRequest;
import com.anuj.library_management.domain.dto.CreateBookRequestDto;
import com.anuj.library_management.domain.dto.UpdateBookRequestDto;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;
import com.anuj.library_management.mapper.BookMapper;
import com.anuj.library_management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,BookMapper bookMapper){
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody CreateBookRequestDto createBookRequestDto){
        CreateBookRequest createBookRequest = bookMapper.fromDto(createBookRequestDto);
        Book book = bookService.createBook(createBookRequest);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID uuid){
        Book book = bookService.getBookById(uuid);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> book = bookService.getAllBooks();
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Book> updateBook(@PathVariable UUID uuid,@Valid @RequestBody UpdateBookRequestDto updateBookRequestDto){
        UpdateBookRequest updateBookRequest = bookMapper.fromDto(uuid,updateBookRequestDto);
        Book book = bookService.updateBook(updateBookRequest.author_id(),updateBookRequest);
        return new ResponseEntity<Book>(book,HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID uuid){
        bookService.deleteBook(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
