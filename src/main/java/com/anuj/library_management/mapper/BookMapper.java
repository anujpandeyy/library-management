package com.anuj.library_management.mapper;

import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.dto.CreateBookRequestDto;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;

public interface BookMapper {
    CreateBookRequest fromDto(CreateBookRequestDto dto);
    Book toEntity(CreateBookRequest createBookRequest, Author author);
}