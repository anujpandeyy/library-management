package com.anuj.library_management.mapper.impl;

import com.anuj.library_management.domain.CreateAuthorRequest;
import com.anuj.library_management.domain.UpdateAuthorRequest;
import com.anuj.library_management.domain.dto.CreateAuthorRequestDto;
import com.anuj.library_management.domain.dto.UpdateAuthorRequestDto;
import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.mapper.AuthorMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public CreateAuthorRequest fromDto(CreateAuthorRequestDto createAuthorRequestDto) {
        if(createAuthorRequestDto==null){
            return null;
        }
        return new CreateAuthorRequest(
                createAuthorRequestDto.name(),
                createAuthorRequestDto.email(),
                createAuthorRequestDto.date_of_birth()
        );
    }

    @Override
    public Author toEntity(CreateAuthorRequest createAuthorRequest) {
        if(createAuthorRequest==null){
            return null;
        }
        return new Author(
                createAuthorRequest.name(),
                createAuthorRequest.email(),
                createAuthorRequest.date_of_birth()
        );

    }

    @Override
    public UpdateAuthorRequest fromDto(UpdateAuthorRequestDto updateAuthorRequestDto) {
        if(updateAuthorRequestDto==null){
            return null;
        }
        return new UpdateAuthorRequest(
         updateAuthorRequestDto.name(),
         updateAuthorRequestDto.email(),
         updateAuthorRequestDto.date_of_birth()
        );
    }
}
