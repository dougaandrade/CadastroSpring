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

  @GetMapping("/listar")
  public String listarMissoes() {
    return "Listagem de missoes";
  }

  @PostMapping("/criar")
  public String criarMisssao() {
    return "Missao criada";
  }

  @PutMapping("/atualizar")
  public String atualizarMisssao() {
    return "Missao atualizada";
  }

  @DeleteMapping("/deletar")
  public String deletarMisssao() {
    return "Missao deletada";
  }


}
