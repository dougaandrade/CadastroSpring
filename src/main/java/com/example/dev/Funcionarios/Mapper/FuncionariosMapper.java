package com.example.dev.Funcionarios.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Funcionarios.DTO.FuncionariosRequest.FuncionariosRequest;
import com.example.dev.Funcionarios.DTO.FuncionariosResponse.FuncionariosResponse;
import com.example.dev.Funcionarios.Model.FuncionariosModel;

@Component
public class FuncionariosMapper {

  public FuncionariosModel mapToModel(FuncionariosRequest request) {
    return FuncionariosModel.builder()
        .codFuncionario(request.getCodFuncionario())
        .nome(request.getNome())
        .email(request.getEmail())
        .idade(request.getIdade())
        .cpf(request.getCpf())
        .dataNascimento(request.getDataNascimento())
        .setor(request.getSetor())
        .build();
  }

  public FuncionariosResponse mapToResponse(FuncionariosModel model) {
    return FuncionariosResponse.builder()
        .codFuncionario(model.getCodFuncionario())
        .nome(model.getNome())
        .email(model.getEmail())
        .idade(model.getIdade())
        .cpf(model.getCpf())
        .dataNascimento(model.getDataNascimento())
        .setor(model.getSetor())
        .build();
  }
}