package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetoresDTO {

  private Long id;
  private String setor;
  private String descricao;
  private List<FuncionariosModel> funcionarios;

}
