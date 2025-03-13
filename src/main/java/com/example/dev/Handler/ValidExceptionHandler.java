package com.example.dev.Handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno: " + ex.getMessage());
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    return "Verifique se o setor informado existe.";
  }
}
