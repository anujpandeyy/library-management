package com.anuj.library_management.domain;

import com.anuj.library_management.domain.enums.MemberType;

import java.time.LocalDate;

public record CreateMemberRequest(
        String name,
        LocalDate memberShipDate,
        MemberType memberType
) {
}
