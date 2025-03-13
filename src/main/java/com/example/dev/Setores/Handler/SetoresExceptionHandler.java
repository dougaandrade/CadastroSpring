package com.example.dev.Setores.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dev.Setores.Exceptions.SetoresException;

@RestControllerAdvice
public class SetoresExceptionHandler {

  @ExceptionHandler(SetoresException.class)
  public ResponseEntity<String> handleSetoresException(SetoresException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Campos do Setor inválido!");} 
}
