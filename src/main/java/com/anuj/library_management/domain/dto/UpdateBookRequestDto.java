package com.anuj.library_management.domain.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateBookRequestDto(
        @NotBlank(message = ERROR_MESSAGE_NAME)
        @Length(max = 255, message = ERROR_MESSAGE_NAME)
        String name,
        @NotBlank(message = ERROR_MESSAGE_ISBN)
        @Size(min=13,max = 13,message = ERROR_MESSAGE_ISBN)
        @Pattern(regexp = "\\d{13}",message = ERROR_MESSAGE_ISBN)
        String ISBN,
        @NotNull(message = ERROR_MESSAGE_AUTHOR)
        UUID author_id,
        @NotNull(message = ERROR_MESSAGE_PUBLISHED)
        @PastOrPresent(message = ERROR_MESSAGE_PUBLISHED)
        LocalDate published,
        @Min(value = 1,message= ERROR_MESSAGE_PAGES)
        int pages
) {
    public static final String ERROR_MESSAGE_NAME = "Name can be between 1 to 255 characters.";
    public static final String ERROR_MESSAGE_ISBN = "ISBN must be 13 digits.";
    public static final String ERROR_MESSAGE_AUTHOR = "Author can be between 1 to 255 characters.";
    public static final String ERROR_MESSAGE_PUBLISHED = "The Published Year must be provided in Past.";
    public static final String ERROR_MESSAGE_PAGES = "Pages can't be negative.";
}
