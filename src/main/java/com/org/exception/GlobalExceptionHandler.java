package com.org.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler (ResourceNotFoundException.class)
    public ProblemDetail handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ProblemDetail pd= ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Recurso no encontrado");
        pd.setDetail(ex.getMessage());
        pd.setProperty("path", request.getDescription(false));
        return pd;
    }

    @ExceptionHandler
    public ProblemDetail handleDuplicate(DuplicateResourceException ex,WebRequest request) {
        ProblemDetail pd= ProblemDetail.forStatus(HttpStatus.CONFLICT);
        pd.setTitle("Duplicado");
        pd.setDetail(ex.getMessage());
        pd.setProperty("path", request.getDescription(false));
        return pd;
    }

    @ExceptionHandler
    public ProblemDetail handleGeneric(BadRequestException ex, WebRequest request) {
        ProblemDetail pd= ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("Internal Server Error");
        pd.setDetail(ex.getMessage());
        pd.setProperty("path", request.getDescription(false));
        return pd;
    }

}
