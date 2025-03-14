package com.example.dev.Funcionarios.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Setores.Model.SetoresModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

  private Long codFuncionario;

  private String nome;

  private String email;

  private int idade;

  private Cpf cpf;

  private LocalDate dataNascimento;

  private SetoresModel setor;
}
