package com.example.dev.Funcionarios.Model;

import com.example.dev.Exceptions.ValidException;

import jakarta.persistence.Embeddable;

@Embeddable
public class Nome {

  private String nome;

  protected Nome() {
  }

  public Nome(String nome) {
    this.nome = nome;
    ValidarNome(nome);
  }

  public String getNome() {
    return nome;
  }

  public void ValidarNome(String nome) {
    if (nome.matches("\\s+") ||
        !nome.matches("^[A-Za-z]+$")) {
      throw new ValidException("Nome inválido!");
    }
  }
}
