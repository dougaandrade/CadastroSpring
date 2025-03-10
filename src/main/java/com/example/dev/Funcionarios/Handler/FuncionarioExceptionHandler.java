package com.example.dev.Funcionarios.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dev.Funcionarios.Exceptions.FuncionarioException;

@ControllerAdvice
public class FuncionarioExceptionHandler {

  @ResponseBody
  @ExceptionHandler(FuncionarioException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleFuncionarioCriadoException(FuncionarioException ex) {
    return ex.getMessage();
  }

}
