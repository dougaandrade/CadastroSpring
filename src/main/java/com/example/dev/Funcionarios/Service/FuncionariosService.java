package com.example.dev.Funcionarios.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Exceptions.ValidException;
import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
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
      throw new ValidException("Funcionario não encontrado");
    }
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionariosMapper::map);
  }

  public FuncionariosDTO criarNovoFuncionario(FuncionariosDTO funcionarioDTO) {
    funcionariosRepository.findByCpf(funcionarioDTO.getCpf()).ifPresent(funcionario -> {
      throw new ValidException("Funcionário já cadastrado com esse CPF!");
    });
    FuncionariosModel funcionario = funcionariosMapper.map(funcionarioDTO);
    funcionario = funcionariosRepository.save(funcionario);
    return funcionariosMapper.map(funcionario);
  }

  public void deletarFuncionarioCod(Long codFuncionario) {
    if (!funcionariosRepository.existsById(codFuncionario)) {
      throw new ValidException("Funcionário não encontrado para exclusão");
    }
    funcionariosRepository.deleteById(codFuncionario);
  }

  public FuncionariosDTO atualizarFuncionarioByCod(Long codFuncionario, FuncionariosDTO funcionarioDTO) {
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionario -> {
          atualizarDadosFuncionario(funcionario, funcionarioDTO);
          return funcionariosMapper.map(funcionariosRepository.save(funcionario));
        })
        .orElseThrow(() -> new ValidException("Funcionário não encontrado"));
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
