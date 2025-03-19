package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Enum.StatusSetor;
import com.example.dev.Funcionarios.Model.FuncionariosModel;

import jakarta.validation.constraints.NotBlank;
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

  @Size(min = 2, max = 100, message = "{Size.setor}")
  @NotNull(message = "{NotNull.setor}")
  @NotBlank(message = "{NotBlank.setor}")
  private String setor;

  @NotNull(message = "{NotNull.descricao}")
  @Size(min = 5, max = 255, message = "{Size.descricao}")
  private String descricao;

  @NotNull(message = "{NotNull.status}")
  private StatusSetor status;

  private List<FuncionariosModel> funcionarios;

}
