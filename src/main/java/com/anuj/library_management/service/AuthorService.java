package com.anuj.library_management.service;

import com.anuj.library_management.domain.CreateAuthorRequest;
import com.anuj.library_management.domain.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(CreateAuthorRequest author);
    Author getAuthorById(UUID uuid);
    List<Author> getAllAuthors();
}
