package com.example.dev.Funcionarios.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
import com.example.dev.Funcionarios.Model.FuncionariosModel;

@Component
public class FuncionariosMapper {

  public FuncionariosModel map(FuncionariosDTO funcionariosDTO) {

    FuncionariosModel funcionariosModel = new FuncionariosModel();
    funcionariosModel.setCodFuncionario(funcionariosDTO.getCodFuncionario());
    funcionariosModel.setNome(funcionariosDTO.getNome());
    funcionariosModel.setEmail(funcionariosDTO.getEmail());
    funcionariosModel.setIdade(funcionariosDTO.getIdade());
    funcionariosModel.setCpf(funcionariosDTO.getCpf());
    funcionariosModel.setDataNascimento(funcionariosDTO.getDataNascimento());
    funcionariosModel.setSetor(funcionariosDTO.getSetor());

    return funcionariosModel;
  }

  public FuncionariosDTO map(FuncionariosModel funcionariosModel) {

    FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
    funcionariosDTO.setCodFuncionario(funcionariosModel.getCodFuncionario());
    funcionariosDTO.setNome(funcionariosModel.getNome());
    funcionariosDTO.setEmail(funcionariosModel.getEmail());
    funcionariosDTO.setIdade(funcionariosModel.getIdade());
    funcionariosDTO.setCpf(funcionariosModel.getCpf());
    funcionariosDTO.setDataNascimento(funcionariosModel.getDataNascimento());
    funcionariosDTO.setSetor(funcionariosModel.getSetor());

    return funcionariosDTO;
  }
}