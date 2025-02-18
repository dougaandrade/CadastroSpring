package com.example.dev.Missoes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

  // GET -- Mandar uma requisao para mostrar as missoes
  @GetMapping("/listar")
  public String listarMissoes() {
    return "Listagem de missoes";
  }

   // Post -- Mandar uma requisao para criar as missoes
  @PostMapping("/criar")
  public String criarMisssao() {
    return "Missao criada";
  }

  // PUT -- Mandar uma requisao para alterar as missoes
  @PutMapping("/atualizar")
  public String atualizarMisssao() {
    return "Missao atualizada";
  }

  // Delete -- Mandar uma requisao para deletar as missoes
  @DeleteMapping("/deletar")
  public String deletarMisssao() {
    return "Missao deletada";
  }


}
