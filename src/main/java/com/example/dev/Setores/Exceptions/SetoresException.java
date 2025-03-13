package com.example.dev.Setores.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class SetoresException extends RuntimeException {
  public SetoresException(String message) {
    super(message);
  }
}
