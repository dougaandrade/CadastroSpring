package com.example.dev.Setores.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.Setores.DTO.SetoresResponse.SetoresResponse;
import com.example.dev.Setores.DTO.SetoresResquest.SetoresRequest;
import com.example.dev.Setores.Service.SetoresService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/setor")
@AllArgsConstructor
public class SetoresController {

  SetoresService setoresService;

  // Post -- Mandar uma requisao para criar as missoes

  @PostMapping
  @Operation(summary = "Cria um novo setor", description = "Rota cria um novo setor e insere no banco de dados")

  public ResponseEntity<String> criarSetor(@RequestBody SetoresRequest setores) {
    setoresService.criarSetor(setores);
    return ResponseEntity.status(201).body("Setor criado com sucesso");

  }

  // GET -- Mandar uma requisao para mostrar as setores

  @GetMapping
  @Operation(summary = "Listar todos os setores", description = "Rota listar todos os setores")

  public ResponseEntity<List<SetoresResponse>> listarSetores() {
    List<SetoresResponse> setores = setoresService.listarSetor();
    return ResponseEntity.ok(setores);
  }

  // GET -- Mandar uma requisao para mostrar as missoes

  @GetMapping("/obter/{id}")
  @Operation(summary = "Busca um setor pelo codigo", description = "Rota busca um setor pelo codigo")

  public ResponseEntity<Optional<SetoresResponse>> setoresPorId(@PathVariable Long id) {
    Optional<SetoresResponse> setores = setoresService.obterPorId(id);
    return ResponseEntity.ok(setores);
  }

  // PUT -- Mandar uma requisao para alterar as missoes

  @PatchMapping("/alterar/{id}")
  @Operation(summary = "Altera um setor pelo codigo", description = "Rota altera um setor pelo codigo")

  public ResponseEntity<String> atualizarSetor(@Valid @PathVariable Long id, @RequestBody SetoresRequest Setores) {
    setoresService.alterarSetor(id, Setores);
    return ResponseEntity.ok().body("Setor com ID " + id + " atualizada com sucesso");
  }

  // Delete -- Mandar uma requisao para deletar as missoes

  @DeleteMapping("/deletar/{id}")
  @Operation(summary = "Deleta um setor pelo codigo", description = "Rota deleta um setor pelo codigo")

  public ResponseEntity<String> deletarMisssao(@PathVariable Long id) {
    setoresService.deletarSetorID(id);
    return ResponseEntity.ok().body("Setor com ID " + id + " deletada com sucesso");
  }

}
