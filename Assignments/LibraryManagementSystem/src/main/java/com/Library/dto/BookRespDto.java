package com.Library.dto;

import com.Library.enums.Genre;
import com.Library.enums.MembershipType;
import com.Library.enums.Status;

public record BookRespDto(
        String title,
        Genre genre,
        Status status,
        int publishedYear,
        String authorName,
        String borrowerName,
        String borrowerEmail,
        MembershipType membershipType
) {
}
