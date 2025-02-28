package com.example.dev.Setores.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Mapper.SetoresMapper;
import com.example.dev.Setores.Model.SetoresModel;
import com.example.dev.Setores.Repository.SetoresRepository;

@Service
public class SetoresService {

  public final SetoresMapper setoresMapper;
  public final SetoresRepository setoresRepository;

  public SetoresService(SetoresMapper setoresMapper, SetoresRepository setoresRepository) {
    this.setoresMapper = setoresMapper;
    this.setoresRepository = setoresRepository;
  }

  public SetoresDTO criarSetor(SetoresDTO setoresDTO) {
    SetoresModel setores = setoresMapper.map(setoresDTO);
    setores = setoresRepository.save(setores);
    return setoresMapper.map(setores);
  }

  public List<SetoresDTO> listarSetor() {
    List<SetoresModel> setores = setoresRepository.findAll();
    return setores.stream().map(setoresMapper::map).toList();

  }

  public SetoresDTO obterPorId(Long id) {
    Optional<SetoresModel> setoresID = setoresRepository.findById(id);
    return setoresID.map(setoresMapper::map).orElse(null);
  }

  public SetoresDTO alterarSetor(Long id, SetoresDTO setoresDTO) {
    Optional<SetoresModel> setoresID = setoresRepository.findById(id);
    if (setoresID.isPresent()) {
      SetoresModel setoresModel = setoresID.get();
      if (setoresDTO.getSetor() != null) {
        setoresModel.setSetor(setoresDTO.getSetor());
      }
      if (setoresDTO.getDescricao() != null) {
        setoresModel.setDescricao(setoresDTO.getDescricao());
      }
      if (setoresDTO.getFuncionarios() != null) {
        setoresModel.setFuncionarios(setoresDTO.getFuncionarios());
      }
      SetoresModel setoresSalvo = setoresRepository.save(setoresModel);
      return setoresMapper.map(setoresSalvo);
    }
    return null;
  }

  public void deletarSetorID(Long id) {
    setoresRepository.deleteById(id);
  }

}
