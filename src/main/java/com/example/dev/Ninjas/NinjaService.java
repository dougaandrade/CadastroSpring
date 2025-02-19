package com.example.dev.Ninjas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {

  private NinjaRepository ninjaRepository;
  private NinjaMapper ninjaMapper;

  public NinjaService(NinjaRepository ninjaRepository) {
    this.ninjaRepository = ninjaRepository;
    this.ninjaMapper = ninjaMapper;
  }

  // Listar todos os ninjas
  public List<NinjaModel> listarNinjas() {
    return ninjaRepository.findAll();
  }

  // Listar um ninja por id
  public NinjaModel ninjaPorId(Long id) {
    Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
    return ninjaID.orElse(null);
  }

  // Criar um novo ninja
  public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
    NinjaModel ninja = ninjaMapper.map(ninjaDTO);
    ninja = ninjaRepository.save(ninja);
    return ninjaMapper.map(ninja);

  }

  // Deletar um ninja
  public void deletarNinjaID(Long id) {
    ninjaRepository.deleteById(id);
  }

  // Atualizar NINJA
  public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
    if (ninjaRepository.existsById(id)) {
      ninja.setId(id);
      return ninjaRepository.save(ninja);
    } else {
      return null;
    }
  }

}
