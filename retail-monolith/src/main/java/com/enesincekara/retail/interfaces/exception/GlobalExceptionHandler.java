package com.enesincekara.retail.interfaces.exception;

import com.enesincekara.retail.domain.shared.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException e) {
        ErrorResponse error = new ErrorResponse(e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
