package com.example.dev.Setores.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Service.SetoresService;

@RestController
@RequestMapping("/setor")
public class SetoresController {

  SetoresService setoresService;

  public SetoresController(SetoresService setoresService) {
    this.setoresService = setoresService;
  }

  // Post -- Mandar uma requisao para criar as missoes

  @PostMapping("/criar")
  public ResponseEntity<String> criarSetor(@RequestBody SetoresDTO setores) {
    setoresService.criarSetor(setores);
    return ResponseEntity.status(201).body("Setor criado com sucesso");
  }

  // GET -- Mandar uma requisao para mostrar as setores

  @GetMapping("/listar")
  public ResponseEntity<List<SetoresDTO>> listarSetores() {
    List<SetoresDTO> setores = setoresService.listarSetor();
    return ResponseEntity.ok(setores);
  }

  // GET -- Mandar uma requisao para mostrar as missoes

  @GetMapping("/obter/{id}")
  public ResponseEntity<SetoresDTO> setoresPorId(@PathVariable Long id) {
    SetoresDTO setoresDTO = setoresService.obterPorId(id);
    return ResponseEntity.ok(setoresDTO);
  }

  // PUT -- Mandar uma requisao para alterar as missoes

  @PutMapping("/alterar/{id}")
  public ResponseEntity<String> atualizarMisssao(@PathVariable Long id, @RequestBody SetoresDTO SetoresDTO) {
    return ResponseEntity.ok().body("Setor com ID " + id + " atualizada com sucesso");
  }

  // Delete -- Mandar uma requisao para deletar as missoes

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<String> deletarMisssao(@PathVariable Long id) {
    setoresService.deletarSetorID(id);
    return ResponseEntity.ok().body("Setor com ID " + id + " deletada com sucesso");
  }

}
