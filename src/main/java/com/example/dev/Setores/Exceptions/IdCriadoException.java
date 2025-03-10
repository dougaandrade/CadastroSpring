package com.example.dev.Setores.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IdCriadoException extends RuntimeException {

  private final String message;

  @Override
  public String getMessage() {
    return message;
  }
}
