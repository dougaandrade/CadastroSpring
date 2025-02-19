package com.example.dev.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

  public NinjaModel map(NinjaDTO ninjaDTO) {
    NinjaModel ninjaModel = new NinjaModel();
    ninjaModel.setId(ninjaDTO.getId());
    ninjaModel.setNome(ninjaDTO.getNome());
    ninjaModel.setEmail(ninjaDTO.getEmail());
    ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
    ninjaModel.setRank(ninjaDTO.getRank());
    ninjaModel.setIdade(ninjaDTO.getIdade());
    ninjaModel.setClan(ninjaDTO.getClan());
    ninjaModel.setMissoes(ninjaDTO.getMissoes());

    return ninjaModel;
  }

  public NinjaDTO map(NinjaModel ninja) {
    NinjaDTO ninjaDTO = new NinjaDTO();
    ninjaDTO.setId(ninja.getId());
    ninjaDTO.setNome(ninja.getNome());
    ninjaDTO.setEmail(ninja.getEmail());
    ninjaDTO.setImgUrl(ninja.getImgUrl());
    ninjaDTO.setRank(ninja.getRank());
    ninjaDTO.setIdade(ninja.getIdade());
    ninjaDTO.setClan(ninja.getClan());
    ninjaDTO.setMissoes(ninja.getMissoes());

    return ninjaDTO;
  }
}