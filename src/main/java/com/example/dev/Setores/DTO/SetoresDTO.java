package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Setores.Model.Setor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetoresDTO {

  private Long id;

  @NotNull(message = "Nome não pode ser nulo")
  @Size(min = 1, message = "Nome não pode ser vazio")
  private Setor setor;

  @NotNull(message = "Descrição não pode ser nula")
  @Size(min = 1, message = "Descrição não pode ser vazia")
  private String descricao;
  private List<FuncionariosModel> funcionarios;

}
