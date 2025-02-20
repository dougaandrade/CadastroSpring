package com.example.dev.Missoes.Controller;

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

import com.example.dev.Missoes.DTO.MissoesDTO;
import com.example.dev.Missoes.Service.MissoesService;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

  MissoesService missoesService;

  public MissoesController(MissoesService missoesService) {
    this.missoesService = missoesService;
  }

  // GET -- Mandar uma requisao para mostrar as missoes
  @GetMapping("/listar")
  public ResponseEntity<List<MissoesDTO>> listarMissoes() {
    List<MissoesDTO> missoes = missoesService.listarMissoes();
    return ResponseEntity.ok(missoes);
  }

  // GET -- Mandar uma requisao para mostrar as missoes
  @GetMapping("/listar/{id}")
  public ResponseEntity<MissoesDTO> missoesPorId(@PathVariable Long id) {
    MissoesDTO missoes = missoesService.missoesPorId(id);
    return ResponseEntity.ok(missoes);
  }

  // Post -- Mandar uma requisao para criar as missoes
  @PostMapping("/criar")
  public ResponseEntity<String> criarMisssao(@RequestBody MissoesDTO missoes) {
    missoesService.criarMissoes(missoes);
    return ResponseEntity.status(201).body("Missao criada com sucesso");
  }

  // PUT -- Mandar uma requisao para alterar as missoes
  @PutMapping("/atualizar/{id}")
  public ResponseEntity<String> atualizarMisssao(@PathVariable Long id, @RequestBody MissoesDTO missoes) {
    return ResponseEntity.ok().body("Missao " + id + " atualizada com sucesso");
  }

  // Delete -- Mandar uma requisao para deletar as missoes
  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<String> deletarMisssao(@PathVariable Long id) {
    missoesService.deletarMissoesID(id);
    return ResponseEntity.ok().body("Missao " + id + " deletada com sucesso");
  }

}
