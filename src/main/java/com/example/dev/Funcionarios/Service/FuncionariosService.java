package com.example.dev.Funcionarios.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
import com.example.dev.Funcionarios.Mapper.FuncionariosMapper;
import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Funcionarios.Repository.FuncionariosRepository;

@Service
public class FuncionariosService {

  private FuncionariosRepository funcionariosRepository;
  private FuncionariosMapper funcionariosMapper;

  public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosMapper funcionariosMapper) {
    this.funcionariosRepository = funcionariosRepository;
    this.funcionariosMapper = funcionariosMapper;
  }

  public List<FuncionariosDTO> listarFuncionarios() {
    List<FuncionariosModel> funcionarios = funcionariosRepository.findAll();
    return funcionarios.stream().map(funcionariosMapper::map).toList();
  }

  public FuncionariosDTO funcionariosPorId(Long id) {
    Optional<FuncionariosModel> funcionariosID = funcionariosRepository.findById(id);
    return funcionariosID.map(funcionariosMapper::map).orElse(null);
  }

  public FuncionariosDTO criarNovoFuncionario(FuncionariosDTO funcionarioDTO) {
    FuncionariosModel funcionario = funcionariosMapper.map(funcionarioDTO);
    funcionario = funcionariosRepository.save(funcionario);
    return funcionariosMapper.map(funcionario);
  }

  public void deletarFuncionarioID(Long id) {
    funcionariosRepository.deleteById(id);
  }

  public FuncionariosDTO atualizarFuncionarioId(Long id, FuncionariosDTO funcionarioDTO) {
    Optional<FuncionariosModel> funcionarioId = funcionariosRepository.findById(id);
    if (funcionarioId.isPresent()) {
      FuncionariosModel funcionarioModel = funcionariosMapper.map(funcionarioDTO);
      funcionarioModel.setId(id);
      FuncionariosModel funcionarioSalvo = funcionariosRepository.save(funcionarioModel);
      return funcionariosMapper.map(funcionarioSalvo);
    }
    return null;
  }

}
