package com.example.dev.Missoes.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Missoes.DTO.MissoesDTO;
import com.example.dev.Missoes.Model.MissoesModel;

@Component
public class MissoesMapper {

  public MissoesDTO map(MissoesModel missoes) {
    MissoesDTO missoesDTO = new MissoesDTO();
    missoesDTO.setId(missoes.getId());
    missoesDTO.setNome(missoes.getNome());
    missoesDTO.setDificuldade(missoes.getDificuldade());
    missoesDTO.setNinjas(missoes.getNinjas());
    return missoesDTO;

  }

  public MissoesModel map(MissoesDTO missoesDTO) {
    MissoesModel missoes = new MissoesModel();
    missoes.setId(missoesDTO.getId());
    missoes.setNome(missoesDTO.getNome());
    missoes.setDificuldade(missoesDTO.getDificuldade());
    missoes.setNinjas(missoesDTO.getNinjas());
    return missoes;
  }

}
