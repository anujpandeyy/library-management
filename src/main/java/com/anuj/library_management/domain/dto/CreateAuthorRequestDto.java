package com.anuj.library_management.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record CreateAuthorRequestDto(
        @NotBlank(message = ERROR_MESSAGE_NAME)
        @Length(max = 255,message = ERROR_MESSAGE_NAME)
        String name,
        @NotBlank(message = ERROR_MESSAGE_EMAIL)
        @Email(message = ERROR_MESSAGE_EMAIL)
        String email,
        @NotNull(message = ERROR_MESSAGE_DATE_OF_BIRTH)
        @Past(message = ERROR_MESSAGE_DATE_OF_BIRTH)
        Date date_of_birth
) {
    public static final String ERROR_MESSAGE_NAME = "Name must be Provided and it must be between 1 to 255 characters.";
    public static final String ERROR_MESSAGE_EMAIL = "Email must be a valid email address.";
    public static final String ERROR_MESSAGE_DATE_OF_BIRTH = "Date Of Birth must be provided.";
}
