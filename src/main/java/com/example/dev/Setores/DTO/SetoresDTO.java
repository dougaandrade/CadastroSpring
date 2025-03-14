package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetoresDTO {

  @NotNull(message = "O ID do setor é obrigatório")
  private Long id;

  @NotNull(message = "O setor é obrigatório")
  private String setor;

  @NotNull(message = "A descrição do setor é obrigatória")
  @Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres")
  private String descricao;

  @NotEmpty(message = "O setor deve conter pelo menos um funcionário")
  private List<FuncionariosModel> funcionarios;

}
