package com.example.dev.Funcionarios.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FuncionarioException extends RuntimeException {

  private final String message;
  private final String details;

  @Override
  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }
}
