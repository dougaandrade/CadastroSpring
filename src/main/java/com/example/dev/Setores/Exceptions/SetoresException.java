package com.example.dev.Setores.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SetoresException extends RuntimeException {

  private final String message;

  @Override
  public String getMessage() {
    return message;
  }

}
