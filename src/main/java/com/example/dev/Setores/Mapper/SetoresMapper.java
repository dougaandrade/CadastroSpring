package com.example.dev.Setores.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Model.SetoresModel;

@Component
public class SetoresMapper {

  public SetoresDTO map(SetoresModel setores) {
    SetoresDTO setoresDTO = new SetoresDTO();
    setoresDTO.setId(setores.getId());
    setoresDTO.setNomeSetor(setores.getNomeSetor());
    setoresDTO.setDescricaoSetor(setores.getDescricaoSetor());

    return setoresDTO;

  }

  public SetoresModel map(SetoresDTO setoresDTO) {
    SetoresModel setoresModel = new SetoresModel();
    setoresModel.setId(setoresDTO.getId());
    setoresModel.setNomeSetor(setoresDTO.getNomeSetor());
    setoresModel.setDescricaoSetor(setoresDTO.getDescricaoSetor());

    return setoresModel;
  }

}
