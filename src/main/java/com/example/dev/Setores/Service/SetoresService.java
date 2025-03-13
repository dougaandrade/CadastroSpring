package com.example.dev.Setores.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Exceptions.SetoresException;
import com.example.dev.Setores.Mapper.SetoresMapper;
import com.example.dev.Setores.Model.SetoresModel;
import com.example.dev.Setores.Repository.SetoresRepository;

@Service
public class SetoresService {

  private final SetoresMapper setoresMapper;
  private final SetoresRepository setoresRepository;

  public SetoresService(SetoresMapper setoresMapper, SetoresRepository setoresRepository) {
    this.setoresMapper = setoresMapper;
    this.setoresRepository = setoresRepository;
  }

  public SetoresDTO criarSetor(SetoresDTO setoresDTO) {
    setoresRepository.findBySetor(setoresDTO.getSetor())
        .ifPresent(setor -> {
          throw new SetoresException("Setor já cadastrado!");
        });

    SetoresModel setores = setoresMapper.map(setoresDTO);
    setores = setoresRepository.save(setores);
    return setoresMapper.map(setores);
  }

  public List<SetoresDTO> listarSetor() {
    return setoresRepository.findAll()
        .stream()
        .map(setoresMapper::map)
        .toList();
  }

  public Optional<SetoresDTO> obterPorId(Long id) {
    return setoresRepository.findById(id)
        .map(setoresMapper::map);
  }

  public SetoresDTO alterarSetor(Long id, SetoresDTO setoresDTO) {
    return setoresRepository.findById(id)
        .map(setor -> {
          atualizarSetor(setor, setoresDTO);
          return setoresMapper.map(setoresRepository.save(setor));
        })
        .orElseThrow(() -> new SetoresException("Setor não encontrado"));
  }

  private void atualizarSetor(SetoresModel setor, SetoresDTO setoresDTO) {
    Optional.ofNullable(setoresDTO.getSetor()).ifPresent(setor::setSetor);
    Optional.ofNullable(setoresDTO.getDescricao()).ifPresent(setor::setDescricao);
    Optional.ofNullable(setoresDTO.getFuncionarios()).ifPresent(setor::setFuncionarios);
  }

  public void deletarSetorID(Long id) {
    if (!setoresRepository.existsById(id)) {
      throw new SetoresException("Setor não encontrado para exclusão");
    }
    setoresRepository.deleteById(id);
  }
}
