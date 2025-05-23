package com.org.dto.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;




public record DeveloperRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max=100, message = "No debe pasar de 100 caracteres")
        String name
) {}
