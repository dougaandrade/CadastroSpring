package com.example.dev.Funcionarios.Model;

import jakarta.persistence.Embeddable;
import java.util.Objects;

import com.example.dev.Funcionarios.Exceptions.FuncionarioCriadoException;

@Embeddable
public class Cpf {
  private String numero;

  protected Cpf() {
  } // Construtor padrão para JPA

  public Cpf(String numero) {
    validarCpf(numero);
    this.numero = numero;
  }

  private void validarCpf(String numero) {
    if (numero == null || !numero.matches("\\d{11}")) {
      throw new FuncionarioCriadoException("CPF inválido!", "O CPF deve conter 11 dígitos.");
    }
  }

  public String getNumero() {
    return numero;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Cpf cpf = (Cpf) o;
    return Objects.equals(numero, cpf.numero);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero);
  }
}
