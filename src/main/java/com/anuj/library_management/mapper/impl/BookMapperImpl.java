package com.anuj.library_management.mapper.impl;

import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.UpdateBookRequest;
import com.anuj.library_management.domain.dto.CreateBookRequestDto;
import com.anuj.library_management.domain.dto.UpdateBookRequestDto;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;
import com.anuj.library_management.mapper.BookMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public CreateBookRequest fromDto(CreateBookRequestDto dto){
        if(dto==null){
            return null;
        }
        return new CreateBookRequest(
                dto.name(),
                dto.ISBN(),
                dto.author_id(),
                dto.published(),
                dto.pages()
        );
    }
    @Override
    public Book toEntity(CreateBookRequest createBookRequest, Author author){
        if(createBookRequest==null){
            return null;
        }
        return new Book(
                createBookRequest.name(),
                createBookRequest.ISBN(),
                author,
                createBookRequest.published(),
                createBookRequest.pages(),
                true
        );
    }

    @Override
    public UpdateBookRequest fromDto(UUID uuid, UpdateBookRequestDto dto) {
        if (dto==null){
            return null;
        }
        return new UpdateBookRequest(
                dto.name(),
                dto.ISBN(),
                dto.author_id(),
                dto.published(),
                dto.pages()
        );
    }
}
