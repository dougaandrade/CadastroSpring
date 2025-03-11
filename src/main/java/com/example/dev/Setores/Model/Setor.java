package com.example.dev.Setores.Model;

import com.example.dev.Setores.Exceptions.SetoresException;

import jakarta.persistence.Embeddable;
import lombok.val;

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
    if (setor.isEmpty() ||
        setor.isBlank() ||
        setor.matches("\\s+") ||
        !setor.matches("^[A-Za-zÀ-ú\\s]+$")) {
      throw new SetoresException("Setor inválido!");
    }
    return setor;
  }

}
