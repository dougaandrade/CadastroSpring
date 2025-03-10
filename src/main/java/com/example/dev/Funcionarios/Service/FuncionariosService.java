package com.example.dev.Funcionarios.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
import com.example.dev.Funcionarios.Exceptions.FuncionarioException;
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

  public FuncionariosDTO funcionariosByCod(Long codFuncionario) {
    Optional<FuncionariosModel> funcionariosID = funcionariosRepository.findByCodFuncionario(codFuncionario);
    return funcionariosID.map(funcionariosMapper::map).orElse(null);
  }

  public FuncionariosDTO criarNovoFuncionario(FuncionariosDTO funcionarioDTO) {
    FuncionariosModel funcionario = funcionariosMapper.map(funcionarioDTO);
    Optional<FuncionariosModel> setor = funcionariosRepository.findById(funcionario.getSetor().getId());
    if (setor.isEmpty()) {
      throw new FuncionarioException("Setor não encontrado!", "Setor");
    }
    funcionario = funcionariosRepository.save(funcionario);
    return funcionariosMapper.map(funcionario);
  }

  public void deletarFuncionarioCod(Long codFuncionario) {
    funcionariosRepository.deleteById(codFuncionario);
  }

  public FuncionariosDTO atualizarFuncionarioByCod(Long codFuncionario, FuncionariosDTO funcionarioDTO) {
    Optional<FuncionariosModel> funcionarioId = funcionariosRepository.findByCodFuncionario(codFuncionario);
    if (funcionarioId.isPresent()) {
      FuncionariosModel funcionarioModel = funcionarioId.get();
      if (funcionarioDTO.getNome() != null) {
        funcionarioModel.setNome(funcionarioDTO.getNome());
      }
      if (funcionarioDTO.getEmail() != null) {
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
      }
      if (funcionarioDTO.getIdade() != 0) {
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
      }
      if (funcionarioDTO.getCpf() != null) {
        funcionarioModel.setCpf(funcionarioDTO.getCpf());
      }
      if (funcionarioDTO.getDataNascimento() != null) {
        funcionarioModel.setDataNascimento(funcionarioDTO.getDataNascimento());
      }
      if (funcionarioDTO.getSetor() != null) {
        funcionarioModel.setSetor(funcionarioDTO.getSetor());
      }
      FuncionariosModel funcionarioSalvo = funcionariosRepository.save(funcionarioModel);
      return funcionariosMapper.map(funcionarioSalvo);
    }
    return null;
  }
}