package com.example.dev.Setores.Model;

import com.example.dev.Exceptions.ValidException;

import jakarta.persistence.Embeddable;

@Embeddable
public class Setor {

  private String setor;

  protected Setor() {
  }

  public Setor(String setor) {
    this.setor = setor;
    ValidarSetor(setor);
  }

  public String getSetor() {
    return setor;
  }

  public String ValidarSetor(String setor) {
    if (setor.matches("\\s+") ||
        !setor.matches("^[A-Za-zÀ-ú\\s]+$")) {
      throw new ValidException("Setor inválido!");
    }
    return setor;
  }

}
