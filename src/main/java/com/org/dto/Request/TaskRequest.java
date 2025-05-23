package com.org.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Description;

import java.time.LocalDate;


public record TaskRequest(
        @NotBlank String title,
        @NotBlank String Description,
        @NotNull Long developerId,
        LocalDate StartDate,
        LocalDate endDate
) {
}
