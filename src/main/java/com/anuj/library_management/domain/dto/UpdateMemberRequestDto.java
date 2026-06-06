package com.anuj.library_management.domain.dto;

import com.anuj.library_management.domain.enums.MemberType;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateMemberRequestDto(
        @NotBlank(message = ERROR_MESSAGE_NAME)
        @Length(max = 255, message = ERROR_MESSAGE_NAME)
        String name,
        @NotBlank(message = ERROR_MESSAGE_MEMBER_SHIP_DATE)
        LocalDate memberShipDate,
        @NotBlank(message = ERROR_MESSAGE_MEMBER_TYPE)
        MemberType memberType
) {
    public static final String ERROR_MESSAGE_NAME = "Name is required and should be between 1 to 255.";
    public static final String ERROR_MESSAGE_MEMBER_SHIP_DATE = "MemberShip is required.";
    public static final String ERROR_MESSAGE_MEMBER_TYPE = "MemberType is required.";
}
