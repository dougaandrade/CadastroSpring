package com.example.dev.Cliente.Mapper;

import org.springframework.stereotype.Component;

import com.example.dev.Cliente.DTO.ClienteDTO;
import com.example.dev.Cliente.Model.ClienteModel;

@Component
public class ClienteMapper {

  public ClienteModel map(ClienteDTO clienteDTO) {

    ClienteModel clienteModel = new ClienteModel();
    clienteModel.setId(clienteDTO.getId());
    clienteModel.setNome(clienteDTO.getNome());
    clienteModel.setEmail(clienteDTO.getEmail());
    clienteModel.setIdade(clienteDTO.getIdade());
    clienteModel.setCpf(clienteDTO.getCpf());
    clienteModel.setDataNascimento(clienteDTO.getDataNascimento());
    clienteModel.setSetores(clienteDTO.getSetores());

    return clienteModel;
  }

  public ClienteDTO map(ClienteModel clienteModel) {
    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setId(clienteModel.getId());
    clienteDTO.setNome(clienteModel.getNome());
    clienteDTO.setEmail(clienteModel.getEmail());
    clienteDTO.setIdade(clienteModel.getIdade());
    clienteDTO.setCpf(clienteModel.getCpf());
    clienteDTO.setDataNascimento(clienteModel.getDataNascimento());
    clienteDTO.setSetores(clienteModel.getSetores());

    return clienteDTO;
  }
}