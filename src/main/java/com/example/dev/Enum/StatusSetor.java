package com.example.dev.Enum;

import com.example.dev.Exceptions.ValidException;

public enum StatusSetor {

  ABERTO(0, "ABERTO"),
  FECHADO(1, "FECHADO");

  private final int cod;
  private final String descricao;

  private StatusSetor(int cod, String descricao) {
    this.cod = cod;
    this.descricao = descricao;
  }

  public int getCod() {
    return cod;
  }

  public String getDescricao() {
    return descricao;
  }

  public static StatusSetor toEnum(Integer cod) {
    if (cod == null) {
      throw new ValidException("Id inválido: " + cod);
    }
    for (StatusSetor x : StatusSetor.values()) {
      if (cod.equals(x.getCod())) {
        return x;
      }
    }
    throw new ValidException("Id inválido: " + cod);
  }

}
