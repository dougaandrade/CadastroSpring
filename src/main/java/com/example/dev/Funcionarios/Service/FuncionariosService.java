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

  private final FuncionariosRepository funcionariosRepository;
  private final FuncionariosMapper funcionariosMapper;

  public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionariosMapper funcionariosMapper) {
    this.funcionariosRepository = funcionariosRepository;
    this.funcionariosMapper = funcionariosMapper;
  }

  public List<FuncionariosDTO> listarFuncionarios() {
    return funcionariosRepository.findAll()
        .stream()
        .map(funcionariosMapper::map)
        .toList();
  }

  public Optional<FuncionariosDTO> funcionariosByCod(Long codFuncionario) {
    if (!funcionariosRepository.existsById(codFuncionario)) {
      throw new FuncionarioException("Funcionario não encontrado", null);
    }
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionariosMapper::map);
  }

  public FuncionariosDTO criarNovoFuncionario(FuncionariosDTO funcionarioDTO) {
    if (funcionariosRepository.findByCpf(funcionarioDTO.getCpf()).isPresent()) {
      throw new FuncionarioException("Funcionário já cadastrado com esse CPF!", "CPF");
    }
    FuncionariosModel funcionario = funcionariosMapper.map(funcionarioDTO);
    funcionario = funcionariosRepository.save(funcionario);
    return funcionariosMapper.map(funcionario);
  }

  public void deletarFuncionarioCod(Long codFuncionario) {
    if (!funcionariosRepository.existsById(codFuncionario)) {
      throw new FuncionarioException("Funcionário não encontrado para exclusão", "COD");
    }
    funcionariosRepository.deleteById(codFuncionario);
  }

  public FuncionariosDTO atualizarFuncionarioByCod(Long codFuncionario, FuncionariosDTO funcionarioDTO) {
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionario -> {
          atualizarDadosFuncionario(funcionario, funcionarioDTO);
          return funcionariosMapper.map(funcionariosRepository.save(funcionario));
        })
        .orElseThrow(() -> new FuncionarioException("Funcionário não encontrado", "COD"));
  }

  private void atualizarDadosFuncionario(FuncionariosModel funcionario, FuncionariosDTO dto) {
    Optional.ofNullable(dto.getNome()).ifPresent(funcionario::setNome);
    Optional.ofNullable(dto.getEmail()).ifPresent(funcionario::setEmail);
    if (dto.getIdade() > 0) {
      funcionario.setIdade(dto.getIdade());
    }
    Optional.ofNullable(dto.getCpf()).ifPresent(funcionario::setCpf);
    Optional.ofNullable(dto.getDataNascimento()).ifPresent(funcionario::setDataNascimento);
    Optional.ofNullable(dto.getSetor()).ifPresent(funcionario::setSetor);
  }
}
