package com.example.dev.Setores.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Model.SetoresModel;

@Component
public class SetoresMapper {

  public SetoresDTO map(SetoresModel setores) {
    SetoresDTO setoresDTO = new SetoresDTO();
    setoresDTO.setId(setores.getId());
    setoresDTO.setSetor(setores.getSetor());
    setoresDTO.setDescricao(setores.getDescricao());

    return setoresDTO;

  }

  public SetoresModel map(SetoresDTO setoresDTO) {
    SetoresModel setoresModel = new SetoresModel();
    setoresModel.setId(setoresDTO.getId());
    setoresModel.setSetor(setoresDTO.getSetor());
    setoresModel.setDescricao(setoresDTO.getDescricao());

    return setoresModel;
  }

}
