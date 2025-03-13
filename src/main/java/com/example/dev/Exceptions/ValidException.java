package com.example.dev.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ValidException extends RuntimeException {
  public ValidException(String message) {
    super(message);
  }
}
