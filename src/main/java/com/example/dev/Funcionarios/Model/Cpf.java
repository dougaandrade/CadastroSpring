package com.example.dev.Funcionarios.Model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

import com.example.dev.Exceptions.ValidException;

@Embeddable
public class Cpf {
  private String cpf_user;

  protected Cpf() {
  } // Construtor padrão para JPA

  public Cpf(String cpf_user) {

    validarCpf(cpf_user);

    this.cpf_user = cpf_user;

  }

  private void validarCpf(String cpf_user) {

    if (!cpf_user.matches("\\d{11}")) {

      throw new ValidException("CPF inválido!, o CPF deve conter 11 dígitos.");
    }
  }

  public String getcpf_user() {

    return cpf_user;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Cpf cpf = (Cpf) o;
    return Objects.equals(cpf_user, cpf.cpf_user);

  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf_user);
  }
}
