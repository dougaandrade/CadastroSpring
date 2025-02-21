package com.example.dev.Cliente.DTO;

import lombok.Data;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import com.example.dev.Setores.Model.SetoresModel;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {

  private long id;
  private String nome;
  private String email;
  private int idade;
  private int cpf;
  private Timestamp dataNascimento;
  private SetoresModel setores;

}
