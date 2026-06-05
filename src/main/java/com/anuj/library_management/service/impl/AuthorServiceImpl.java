package com.anuj.library_management.service.impl;

import com.anuj.library_management.domain.CreateAuthorRequest;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.exception.AuthorNotFoundException;
import com.anuj.library_management.mapper.AuthorMapper;
import com.anuj.library_management.repository.AuthorRepository;
import com.anuj.library_management.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    public AuthorServiceImpl(AuthorRepository authorRepository,AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }
    @Override
    public Author createAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author = authorMapper.toEntity(createAuthorRequest);
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(UUID uuid) {
        return authorRepository.findById(uuid).orElseThrow(()-> new AuthorNotFoundException(uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
