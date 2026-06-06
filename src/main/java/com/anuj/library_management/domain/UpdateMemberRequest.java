package com.anuj.library_management.domain;

import com.anuj.library_management.domain.enums.MemberType;

import java.time.LocalDate;

public record UpdateMemberRequest(
        String name,
        LocalDate memberShipDate,
        MemberType memberType
) {
}
