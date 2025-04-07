package com.example.dev.Handler;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dev.Exceptions.ValidException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ValidExceptionHandler {

  @ExceptionHandler(ValidException.class)
  public ResponseEntity<String> handleSetoresException(ValidException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  // Já existente para validação de DTOs
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    String errors = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getDefaultMessage())
        .collect(Collectors.joining("\n"));
    return ResponseEntity.badRequest().body(errors);
  }

  // Novo: Captura erros de validação no JPA
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
    String errors = ex.getConstraintViolations().stream()
        .map(
            ConstraintViolation::getMessage)
        .collect(Collectors.joining("; "));
    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

}
