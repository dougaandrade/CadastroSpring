package com.example.dev.Funcionarios.Model;

import jakarta.persistence.Embeddable;
import java.util.Objects;

import com.example.dev.Exceptions.ValidException;

@Embeddable
public class Email {
  private String endereco;

  protected Email() {
  }

  public Email(String endereco) {
    validarEmail(endereco);
    this.endereco = endereco;
  }

  private void validarEmail(String endereco) {
    if (!endereco.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
      throw new ValidException("E-mail inválido!");
    }
  }

  public String getEndereco() {
    return endereco;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Email email = (Email) o;
    return Objects.equals(endereco, email.endereco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endereco);
  }
}
