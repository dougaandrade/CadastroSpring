package com.example.dev.Missoes.DTO;

import java.util.List;

import com.example.dev.Ninjas.Model.NinjaModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

  private Long id;
  private String nome;
  private String dificuldade;
  private List<NinjaModel> ninjas;

}
