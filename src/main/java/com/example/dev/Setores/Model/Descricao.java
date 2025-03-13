package com.example.dev.Setores.Model;

import com.example.dev.Setores.Exceptions.SetoresException;

import jakarta.persistence.Embeddable;

@Embeddable
public class Descricao {

  private String descricao;

  protected Descricao() {
  }

  public Descricao(String descricao) {
    this.descricao = descricao;
    ValidarDescricao(descricao);
  }

  public String getDescricao() {
    return descricao;
  }

  public String ValidarDescricao(String descricao) {
    if (descricao.matches("\\s+") ||
        !descricao.matches("^[A-Za-zÀ-ú\\s]+$")) {
      throw new SetoresException("Descrição inválida!");
    }
    return descricao;
  }

}
