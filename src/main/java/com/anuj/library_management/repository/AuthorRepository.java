package com.anuj.library_management.repository;

import com.anuj.library_management.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author,UUID> {
}
