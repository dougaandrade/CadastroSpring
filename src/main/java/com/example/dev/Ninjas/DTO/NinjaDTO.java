package com.example.dev.Ninjas.DTO;

import lombok.Data;

import lombok.NoArgsConstructor;

import com.example.dev.Missoes.Model.MissoesModel;

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
