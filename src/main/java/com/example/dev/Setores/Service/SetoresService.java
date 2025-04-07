package com.example.dev.Setores.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Exceptions.ValidException;
import com.example.dev.Setores.DTO.SetoresResponse.SetoresResponse;
import com.example.dev.Setores.DTO.SetoresResquest.SetoresResquest;
import com.example.dev.Setores.Mapper.SetoresMapper;
import com.example.dev.Setores.Model.SetoresModel;
import com.example.dev.Setores.Repository.SetoresRepository;

import jakarta.validation.Valid;

@Service
public class SetoresService {

  private final SetoresMapper setoresMapper;
  private final SetoresRepository setoresRepository;

  public SetoresService(SetoresMapper setoresMapper, SetoresRepository setoresRepository) {
    this.setoresMapper = setoresMapper;
    this.setoresRepository = setoresRepository;
  }

  public SetoresResponse criarSetor(@Valid SetoresResquest setoresRequest) {
    setoresRepository.findBySetor(setoresRequest.getSetor())
        .ifPresent(setor -> {
          throw new ValidException("Setor já cadastrado!");
        });

    SetoresModel setor = setoresMapper.map(setoresRequest);
    setor = setoresRepository.save(setor);
    return setoresMapper.map(setor);
  }

  public List<SetoresResponse> listarSetor() {
    return setoresRepository.findAll()
        .stream()
        .map(setoresMapper::map)
        .toList();
  }

  public Optional<SetoresResponse> obterPorId(Long id) {
    return setoresRepository.findById(id)
        .map(setoresMapper::map);
  }

  public SetoresModel alterarSetor(Long id, SetoresResquest setoresRequest) {
    return setoresRepository.findById(id)
        .map(setor -> {
          atualizarSetor(setor, setoresRequest);
          return setoresRepository.save(setor);
        })
        .orElseThrow(() -> new ValidException("Setor não encontrado"));
  }

  private void atualizarSetor(SetoresModel setor, SetoresResquest setoresRequest) {
    Optional.ofNullable(setoresRequest.getSetor()).ifPresent(setor::setSetor);
    Optional.ofNullable(setoresRequest.getDescricao()).ifPresent(setor::setDescricao);
    Optional.ofNullable(setoresRequest.getFuncionarios()).ifPresent(setor::setFuncionarios);
    Optional.ofNullable(setoresRequest.getStatus()).ifPresent(setor::setStatus);
  }

  public void deletarSetorID(Long id) {
    if (!setoresRepository.existsById(id)) {
      throw new ValidException("Setor não encontrado para exclusão");
    }
    setoresRepository.deleteById(id);
  }
}
