package com.example.dev.Ninjas;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/bemvindo")
    public String BoasVindas() {
        return "Bem vindo ao Cadastro de Ninja";
    }
    @PostMapping("/criar")
    public String criarNinja() {

        return "Ninja criado";
    }
    
    @GetMapping("/all")
    public String todosNinjas() {
        return "Todos os Ninjas";
    }
    
    @GetMapping("/id")
    public String ninjaPorId() {
        return "Ninja com id ";
    }

    @PutMapping("/atualizar")
    public String atualizarNinja() {
        return "Ninja com id  atualizado";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinja() {
        return "Ninja com id deletado";
    }

}