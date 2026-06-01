package com.anuj.library_management.domain;

import com.anuj.library_management.domain.entity.Author;

import java.time.LocalDate;
import java.util.UUID;

public record CreateBookRequest(
        String name,
        String ISBN,
        UUID author_id,
        LocalDate published,
        int pages
) {
}
