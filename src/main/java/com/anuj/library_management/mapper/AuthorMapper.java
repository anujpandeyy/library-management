package com.anuj.library_management.mapper;

import com.anuj.library_management.domain.CreateAuthorRequest;
import com.anuj.library_management.domain.CreateBookRequest;
import com.anuj.library_management.domain.UpdateAuthorRequest;
import com.anuj.library_management.domain.dto.CreateAuthorRequestDto;
import com.anuj.library_management.domain.dto.CreateBookRequestDto;
import com.anuj.library_management.domain.dto.UpdateAuthorRequestDto;
import com.anuj.library_management.domain.entity.Author;

public interface AuthorMapper {
    CreateAuthorRequest fromDto(CreateAuthorRequestDto createAuthorRequestDto);
    Author toEntity(CreateAuthorRequest createAuthorRequest);
    UpdateAuthorRequest fromDto(UpdateAuthorRequestDto updateAuthorRequestDto);
}
