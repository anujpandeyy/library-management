package com.anuj.library_management.mapper;

import com.anuj.library_management.domain.CreateMemberRequest;
import com.anuj.library_management.domain.dto.CreateMemberRequestDto;
import com.anuj.library_management.domain.entity.Member;

public interface MemberMapper {
    CreateMemberRequest fromDto(CreateMemberRequestDto dto);
    Member toEntity(CreateMemberRequest createMemberRequest);
}
