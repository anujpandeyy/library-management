package com.anuj.library_management.controller;

import com.anuj.library_management.domain.CreateAuthorRequest;
import com.anuj.library_management.domain.dto.CreateAuthorRequestDto;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.mapper.AuthorMapper;
import com.anuj.library_management.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;
    public AuthorController(AuthorService authorService,AuthorMapper authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody CreateAuthorRequestDto createAuthorRequestDto){
        CreateAuthorRequest createAuthorRequest = authorMapper.fromDto(createAuthorRequestDto);
        Author author = authorService.createAuthor(createAuthorRequest);
        return new ResponseEntity<>(author,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable UUID id){
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

}
