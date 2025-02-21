package com.example.dev.Funcionarios.DTO;

import lombok.Data;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import com.example.dev.Setores.Model.SetoresModel;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FuncionariosDTO {

  private long id;
  private String nome;
  private String email;
  private int idade;
  private int cpf;
  private Timestamp dataNascimento;
  private SetoresModel setor;

}
