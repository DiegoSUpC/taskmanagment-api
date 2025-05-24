package com.org.dto.Response;


import java.time.LocalDate;
public record TaskResponse(
        Long id,
        String tittle,
        String description,
        String Status,
        String developerName,
        LocalDate StartDate,
        LocalDate endDate)
{}
