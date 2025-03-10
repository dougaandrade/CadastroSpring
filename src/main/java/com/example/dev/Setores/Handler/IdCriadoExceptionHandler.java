package com.example.dev.Setores.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dev.Setores.Exceptions.IdCriadoException;

@ControllerAdvice
public class IdCriadoExceptionHandler {

  @ResponseBody
  @ExceptionHandler(IdCriadoException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleSetorCriadoException(IdCriadoException ex) {
    return ex.getMessage();
  }
}
