package com.example.dev.Funcionarios.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Funcionarios.Model.Email;
import com.example.dev.Funcionarios.Model.Nome;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

  private Long codFuncionario;

  @NotNull
  @NotBlank
  @NotEmpty
  @Size(min = 1)
  private Nome nome;

  @NotNull
  @NotBlank
  @NotEmpty
  private Email email;

  @NotNull
  @NotBlank
  @NotEmpty
  @Min(value = 18)
  private int idade;

  @NotNull
  @NotBlank
  @NotEmpty
  private Cpf cpf;

  @Past
  @NotNull
  @NotBlank
  @NotEmpty
  private LocalDate dataNascimento;

  @NotNull
  @NotBlank
  @NotEmpty
  private SetoresModel setor;
}
