package com.example.dev.Funcionarios.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Funcionarios.Model.Email;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

  @PositiveOrZero(message = "Código do funcionário não pode ser negativo")
  private Long codFuncionario;

  @NotNull(message = "Nome não pode ser nulo")
  @Size(min = 1)
  private String nome;

  private Email email;

  @Min(value = 18)
  private int idade;

  private Cpf cpf;

  @Past
  private LocalDate dataNascimento;

  private SetoresModel setor;
}
