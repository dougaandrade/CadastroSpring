package com.example.dev.Setores.DTO.SetoresResponse;

import java.util.List;

import com.example.dev.Enum.StatusSetor;
import com.example.dev.Funcionarios.Model.FuncionariosModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SetoresResponse {

  private Long id;
  private String setor;
  private String descricao;
  private StatusSetor status;
  private List<FuncionariosModel> funcionarios;

}
