package com.anuj.library_management.service.impl;

import com.anuj.library_management.domain.CreateMemberRequest;
import com.anuj.library_management.domain.entity.Member;
import com.anuj.library_management.exception.MemberNotFoundException;
import com.anuj.library_management.mapper.MemberMapper;
import com.anuj.library_management.repository.MemberRepository;
import com.anuj.library_management.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository,MemberMapper memberMapper){
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public Member createMember(CreateMemberRequest createMemberRequest) {
        Member member = memberMapper.toEntity(createMemberRequest);
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(UUID uuid) {
        return memberRepository.findById(uuid).orElseThrow(()-> new MemberNotFoundException(uuid));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
