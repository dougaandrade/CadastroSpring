package com.example.dev.Setores.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Setores.DTO.SetoresResponse.SetoresResponse;
import com.example.dev.Setores.DTO.SetoresResquest.SetoresRequest;
import com.example.dev.Setores.Model.SetoresModel;

@Component
public class SetoresMapper {

  // Request -> Model
  public SetoresModel map(SetoresRequest request) {

    return SetoresModel.builder()
        .id(request.getId())
        .setor(request.getSetor())
        .descricao(request.getDescricao())
        .status(request.getStatus())
        .funcionarios(request.getFuncionarios()) // considerar mapear com FuncionarioMapper
        .build();
  }

  // Model -> Response
  public SetoresResponse map(SetoresModel model) {

    return SetoresResponse.builder()
        .id(model.getId())
        .setor(model.getSetor())
        .descricao(model.getDescricao())
        .status(model.getStatus())
        .funcionarios(model.getFuncionarios()) // considerar mapear com FuncionarioMapper
        .build();
  }
}
