package com.anuj.library_management.domain;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateBookRequest(
        String name,
        String ISBN,
        UUID author_id,
        LocalDate published,
        int pages
) {
}
