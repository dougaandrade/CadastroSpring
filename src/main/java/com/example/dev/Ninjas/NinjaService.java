package com.example.dev.Ninjas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
  
  
  private NinjaRepository ninjaRepository;

  public NinjaService(NinjaRepository ninjaRepository) {
    this.ninjaRepository = ninjaRepository;
  }

  // listar todos os ninjas
  public List<NinjaModel> listarNinjas() {
    return ninjaRepository.findAll();
  }
  
  // Listar um ninja por id
  public NinjaModel ninjaPorId(Long id) {
    Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
    return ninjaID.orElse(null);
  }
  
  // Criar um novo ninja
  public NinjaModel criarNinja(NinjaModel ninja) {
    return ninjaRepository.save(ninja);
  }


  // METODO VOID
  public void deletarNinjaID(Long id) {
    ninjaRepository.deleteById(id);
  }


  // Atualizar NINJA

}
