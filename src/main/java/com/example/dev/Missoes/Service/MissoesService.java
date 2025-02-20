package com.example.dev.Missoes.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Missoes.DTO.MissoesDTO;
import com.example.dev.Missoes.Mapper.MissoesMapper;
import com.example.dev.Missoes.Model.MissoesModel;
import com.example.dev.Missoes.Repository.MissoesRepository;

@Service
public class MissoesService {

  public final MissoesMapper missoesMapper;
  public final MissoesRepository missoesRepository;

  public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
    this.missoesMapper = missoesMapper;
    this.missoesRepository = missoesRepository;
  }

  public MissoesDTO criarMissoes(MissoesDTO missoesDTO) {
    MissoesModel missoes = missoesMapper.map(missoesDTO);
    missoes = missoesRepository.save(missoes);
    return missoesMapper.map(missoes);
  }

  public MissoesDTO missoesPorId(Long id) {
    Optional<MissoesModel> missoesID = missoesRepository.findById(id);
    return missoesID.map(missoesMapper::map).orElse(null);
  }

  public MissoesDTO atualizarMissoes(Long id, MissoesDTO missoesDTO) {
    Optional<MissoesModel> missoesID = missoesRepository.findById(id);
    if (missoesID.isPresent()) {
      MissoesModel missoesModel = missoesMapper.map(missoesDTO);
      missoesModel.setId(id);
      MissoesModel missoesSalvo = missoesRepository.save(missoesModel);
      return missoesMapper.map(missoesSalvo);
    }
    return null;
  }

  public void deletarMissoesID(Long id) {
    missoesRepository.deleteById(id);
  }

  public List<MissoesDTO> listarMissoes() {
    List<MissoesModel> missoes = missoesRepository.findAll();
    return missoes.stream().map(missoesMapper::map).toList();

  }

}
