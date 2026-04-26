package com.anuj.library_management.repository;

import com.anuj.library_management.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member,UUID> {
}
