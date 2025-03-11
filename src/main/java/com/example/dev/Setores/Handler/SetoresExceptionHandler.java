package com.example.dev.Setores.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dev.Setores.Exceptions.SetoresException;

@ControllerAdvice
public class SetoresExceptionHandler {

  @ResponseBody
  @ExceptionHandler(SetoresException.class)
  public String handleSetorException(SetoresException ex) {
    return ex.getMessage();
  }

}
