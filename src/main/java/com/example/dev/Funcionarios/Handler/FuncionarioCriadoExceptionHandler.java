package com.example.dev.Funcionarios.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dev.Funcionarios.Exceptions.FuncionarioCriadoException;

@ControllerAdvice
public class FuncionarioCriadoExceptionHandler {

  @ResponseBody
  @ExceptionHandler(FuncionarioCriadoException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleFuncionarioCriadoException(FuncionarioCriadoException ex) {
    return ex.getMessage();
  }

}
