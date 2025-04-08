package com.example.dev.Funcionarios.DTO.FuncionariosResponse;

import java.time.LocalDate;

import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Setores.Model.SetoresModel;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class FuncionariosResponse {

  private Long codFuncionario;
  private String nome;
  private String email;
  private Integer idade;
  private Cpf cpf;
  private LocalDate dataNascimento;
  private SetoresModel setor;
}
