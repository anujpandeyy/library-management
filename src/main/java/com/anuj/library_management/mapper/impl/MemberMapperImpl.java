package com.anuj.library_management.mapper.impl;

import com.anuj.library_management.domain.CreateMemberRequest;
import com.anuj.library_management.domain.UpdateMemberRequest;
import com.anuj.library_management.domain.dto.CreateAuthorRequestDto;
import com.anuj.library_management.domain.dto.CreateMemberRequestDto;
import com.anuj.library_management.domain.dto.UpdateMemberRequestDto;
import com.anuj.library_management.domain.entity.Member;
import com.anuj.library_management.mapper.MemberMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MemberMapperImpl implements MemberMapper {
    @Override
    public CreateMemberRequest fromDto(CreateMemberRequestDto dto) {
        if(dto==null){
            return null;
        }
        return new CreateMemberRequest(
                dto.name(),
                dto.memberShipDate(),
                dto.memberType()
        );
    }

    @Override
    public Member toEntity(CreateMemberRequest createMemberRequest) {
        if(createMemberRequest==null){
            return null;
        }
        return new Member(
                createMemberRequest.name(),
                createMemberRequest.memberShipDate(),
                createMemberRequest.memberType()
        );
    }

    @Override
    public UpdateMemberRequest fromDto(UUID uuid,UpdateMemberRequestDto dto) {
        if (dto==null){
            return null;
        }
        return new UpdateMemberRequest(
                dto.name(),
                dto.memberShipDate(),
                dto.memberType()
        );
    }
}
