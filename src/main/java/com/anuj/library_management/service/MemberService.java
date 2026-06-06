package com.anuj.library_management.service;

import com.anuj.library_management.domain.CreateMemberRequest;
import com.anuj.library_management.domain.UpdateMemberRequest;
import com.anuj.library_management.domain.entity.Member;

import java.util.List;
import java.util.UUID;

public interface MemberService {
    Member createMember(CreateMemberRequest createMemberRequest);
    Member getMemberById(UUID uuid);
    List<Member> getAllMembers();
    Member updateMember(UUID uuid,UpdateMemberRequest updateMemberRequest);
    void deleteMember(UUID uuid);
}
