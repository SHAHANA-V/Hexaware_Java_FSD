package com.springboot.helpdesk.dto.Request;

import com.springboot.helpdesk.enums.JobTitle;

public record JobTitleExecutiveCountDto(
        JobTitle jobTitle,
        long numberOfExecutives
) {
}
