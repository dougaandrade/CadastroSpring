package com.example.dev.Setores.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Setores.DTO.SetoresResponse.SetoresResponse;
import com.example.dev.Setores.DTO.SetoresResquest.SetoresResquest;
import com.example.dev.Setores.Model.SetoresModel;

@Component
public class SetoresMapper {

  public SetoresModel map(SetoresResquest setoresRequest) {
    if (setoresRequest == null) {
      return null;
    }

    return SetoresModel.builder()
        .id(setoresRequest.getId())
        .setor(setoresRequest.getSetor())
        .descricao(setoresRequest.getDescricao())
        .status(setoresRequest.getStatus())
        .funcionarios(setoresRequest.getFuncionarios()) // considerar mapear com FuncionarioMapper
        .build();
  }

  public SetoresResponse map(SetoresModel setoresModel) {
    if (setoresModel == null) {
      return null;
    }

    return SetoresResponse.builder()
        .id(setoresModel.getId())
        .setor(setoresModel.getSetor())
        .descricao(setoresModel.getDescricao())
        .status(setoresModel.getStatus())
        // .funcionarios(setoresModel.getFuncionarios()) // considerar mapear com
        // FuncionarioMapper
        .build();
  }
}
