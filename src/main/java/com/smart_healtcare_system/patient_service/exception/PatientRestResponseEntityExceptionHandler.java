package com.smart_healtcare_system.patient_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class PatientRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldErrorDetail> listError = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(this::mapFieldErrorDetail)
                .toList();

        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .status(status.toString())
                .time(LocalDateTime.now())
                .errorsDetails(listError)
                .build();

        return ResponseEntity.status(ex.getStatusCode()).body(errorMessage);
    }

    private FieldErrorDetail mapFieldErrorDetail(FieldError objectError) {
        return FieldErrorDetail.builder()
                .errorMessage(objectError.getDefaultMessage())
                .nameField(objectError.getField())
                .build();
    }


}
