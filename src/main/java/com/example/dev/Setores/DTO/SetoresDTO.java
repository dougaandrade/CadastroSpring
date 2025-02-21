package com.example.dev.Setores.DTO;

import java.util.List;

import com.example.dev.Cliente.Model.ClienteModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetoresDTO {

  private Long id;
  private String nomeSetor;
  private String descricaoSetor;
  private List<ClienteModel> clientes;

}
