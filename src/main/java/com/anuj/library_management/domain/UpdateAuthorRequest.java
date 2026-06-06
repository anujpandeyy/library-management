package com.anuj.library_management.domain;

import java.util.Date;

public record UpdateAuthorRequest(
        String name,
        String email,
        Date date_of_birth
) {
}
