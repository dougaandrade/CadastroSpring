package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Setores.Model.Descricao;
import com.example.dev.Setores.Model.Setor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetoresDTO {

  private Long id;

  private Setor setor;

  private Descricao descricao;

  private List<FuncionariosModel> funcionarios;

}
