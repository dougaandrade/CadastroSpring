package com.example.dev.Handler;

import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dev.Exceptions.ValidException;

@RestControllerAdvice
public class ValidExceptionHandler {

  @ExceptionHandler(ValidException.class)
  public ResponseEntity<String> handleSetoresException(ValidException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    String errors = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getDefaultMessage()) // Pegando apenas a mensagem de erro
        .collect(Collectors.joining("; ")); // Separando por "; "

    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    return "Verifique se o setor informado existe.";
  }
}
