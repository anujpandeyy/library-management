package com.anuj.library_management.domain;

import java.util.Date;

public record CreateAuthorRequest(
        String name,
        String email,
        Date date_of_birth
) {
}
