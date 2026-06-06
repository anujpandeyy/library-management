package com.anuj.library_management.controller;


import com.anuj.library_management.domain.CreateMemberRequest;
import com.anuj.library_management.domain.dto.CreateMemberRequestDto;
import com.anuj.library_management.domain.entity.Member;
import com.anuj.library_management.mapper.AuthorMapper;
import com.anuj.library_management.mapper.MemberMapper;
import com.anuj.library_management.service.AuthorService;
import com.anuj.library_management.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@Valid @RequestBody CreateMemberRequestDto createMemberRequestDto){
        CreateMemberRequest createMemberRequest = memberMapper.fromDto(createMemberRequestDto);
        Member member = memberService.createMember(createMemberRequest);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberId(@PathVariable UUID id){
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMember(){
        List<Member> memberList = memberService.getAllMembers();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

}
