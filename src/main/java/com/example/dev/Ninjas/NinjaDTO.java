package com.example.dev.Ninjas;

import com.example.dev.Missoes.MissoesModel;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaDTO {

  private long id;
  private String nome;
  private String email;
  private String imgUrl;
  private String rank;
  private int idade;
  private MissoesModel missoes;
  private String clan;

}
