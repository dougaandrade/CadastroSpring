package com.example.dev.Funcionarios.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Exceptions.ValidException;
import com.example.dev.Funcionarios.DTO.FuncionariosRequest.FuncionariosRequest;
import com.example.dev.Funcionarios.DTO.FuncionariosResponse.FuncionariosResponse;
import com.example.dev.Funcionarios.Mapper.FuncionariosMapper;
import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Funcionarios.Repository.FuncionariosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionariosService {

  private final FuncionariosRepository funcionariosRepository;
  private final FuncionariosMapper funcionariosMapper;

  public List<FuncionariosResponse> listarFuncionarios() {
    return funcionariosRepository.findAll()
        .stream()
        .map(funcionariosMapper::mapToResponse)
        .toList();
  }

  public Optional<FuncionariosResponse> funcionariosByCod(Long codFuncionario) {
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionariosMapper::mapToResponse)
        .or(() -> {
          throw new ValidException("Funcionário nao encontrado");
        });
  }

  public FuncionariosResponse criarNovoFuncionario(FuncionariosRequest request) {
    funcionariosRepository.findByCpf(request.getCpf()).ifPresent(funcionario -> {
      throw new ValidException("Funcionário já cadastrado com esse CPF!");
    });
    FuncionariosModel funcionario = funcionariosMapper.mapToModel(request);
    funcionario = funcionariosRepository.save(funcionario);
    return funcionariosMapper.mapToResponse(funcionario);
  }

  public void deletarFuncionarioCod(Long codFuncionario) {
    if (!funcionariosRepository.existsById(codFuncionario)) {
      throw new ValidException("Funcionário não encontrado para exclusão");
    }
    funcionariosRepository.deleteById(codFuncionario);
  }

  public FuncionariosResponse atualizarFuncionarioByCod(Long codFuncionario, FuncionariosResponse request) {
    return funcionariosRepository.findByCodFuncionario(codFuncionario)
        .map(funcionario -> {
          atualizarDadosFuncionario(funcionario, request);
          return funcionariosMapper.mapToResponse(funcionariosRepository.save(funcionario));
        })
        .orElseThrow(() -> new ValidException("Funcionário não encontrado"));
  }

  private void atualizarDadosFuncionario(FuncionariosModel funcionario, FuncionariosResponse request) {
    Optional.ofNullable(request.getNome()).ifPresent(funcionario::setNome);
    Optional.ofNullable(request.getEmail()).ifPresent(funcionario::setEmail);
    Optional.ofNullable(request.getIdade()).ifPresent(funcionario::setIdade);
    Optional.ofNullable(request.getCpf()).ifPresent(funcionario::setCpf);
    Optional.ofNullable(request.getDataNascimento()).ifPresent(funcionario::setDataNascimento);
    Optional.ofNullable(request.getSetor()).ifPresent(funcionario::setSetor);
  }
}
