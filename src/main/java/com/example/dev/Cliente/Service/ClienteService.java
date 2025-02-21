package com.example.dev.Cliente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Cliente.DTO.ClienteDTO;
import com.example.dev.Cliente.Mapper.ClienteMapper;
import com.example.dev.Cliente.Model.ClienteModel;
import com.example.dev.Cliente.Repository.ClienteRepository;

@Service
public class ClienteService {

  private ClienteRepository clienteRepository;
  private ClienteMapper clienteMapper;

  public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
    this.clienteRepository = clienteRepository;
    this.clienteMapper = clienteMapper;
  }

  public List<ClienteDTO> listarClientes() {
    List<ClienteModel> clientes = clienteRepository.findAll();
    return clientes.stream().map(clienteMapper::map).toList();
  }

  public ClienteDTO clientePorId(Long id) {
    Optional<ClienteModel> clienteID = clienteRepository.findById(id);
    return clienteID.map(clienteMapper::map).orElse(null);
  }

  public ClienteDTO criarNovoCliente(ClienteDTO clienteDTO) {
    ClienteModel cliente = clienteMapper.map(clienteDTO);
    cliente = clienteRepository.save(cliente);
    return clienteMapper.map(cliente);
  }

  public void deletarClienteID(Long id) {
    clienteRepository.deleteById(id);
  }

  public ClienteDTO atualizarClienteId(Long id, ClienteDTO clienteDTO) {
    Optional<ClienteModel> clienteID = clienteRepository.findById(id);
    if (clienteID.isPresent()) {
      ClienteModel clienteModel = clienteMapper.map(clienteDTO);
      clienteModel.setId(id);
      ClienteModel clienteSalvo = clienteRepository.save(clienteModel);
      return clienteMapper.map(clienteSalvo);
    }
    return null;
  }

}
