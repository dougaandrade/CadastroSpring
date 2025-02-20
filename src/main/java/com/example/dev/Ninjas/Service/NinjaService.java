package com.example.dev.Ninjas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dev.Ninjas.DTO.NinjaDTO;
import com.example.dev.Ninjas.Mapper.NinjaMapper;
import com.example.dev.Ninjas.Model.NinjaModel;
import com.example.dev.Ninjas.Repository.NinjaRepository;

@Service
public class NinjaService {

  private NinjaRepository ninjaRepository;
  private NinjaMapper ninjaMapper;

  public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
    this.ninjaRepository = ninjaRepository;
    this.ninjaMapper = ninjaMapper;
  }

  public List<NinjaDTO> listarNinjas() {
    List<NinjaModel> ninjas = ninjaRepository.findAll();
    return ninjas.stream().map(ninjaMapper::map).toList();
  }

  public NinjaDTO ninjaPorId(Long id) {
    Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
    return ninjaID.map(ninjaMapper::map).orElse(null);
  }

  public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
    NinjaModel ninja = ninjaMapper.map(ninjaDTO);
    ninja = ninjaRepository.save(ninja);
    return ninjaMapper.map(ninja);
  }

  public void deletarNinjaID(Long id) {
    ninjaRepository.deleteById(id);
  }

  public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
    Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
    if (ninjaID.isPresent()) {
      NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
      ninjaModel.setId(id);
      NinjaModel ninjaSalvo = ninjaRepository.save(ninjaModel);
      return ninjaMapper.map(ninjaSalvo);
    }
    return null;
  }

}
