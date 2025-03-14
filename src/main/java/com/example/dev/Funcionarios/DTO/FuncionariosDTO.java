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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

  @NotNull(message = "O código do funcionário é obrigatório")
  private Long codFuncionario;

  @NotNull(message = "O nome é obrigatório")
  @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
  private Nome nome;

  @NotNull(message = "O e-mail é obrigatório")
  private Email email;

  @Min(value = 18, message = "A idade deve ser maior ou igual a 18")
  private int idade;

  @NotNull(message = "O CPF é obrigatório")
  private Cpf cpf;

  @NotNull(message = "A data de nascimento é obrigatória")
  private LocalDate dataNascimento;

  @NotNull(message = "O setor é obrigatório")
  private SetoresModel setor;
}
