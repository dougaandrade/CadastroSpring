package com.example.dev.Ninjas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.Missoes.MissoesModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    protected NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/bemvindo")
    public String BoasVindas() {
        return "Bem vindo ao Cadastro de Ninja";
    }
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }
    
    @GetMapping("/all")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }
    
    @GetMapping("/listar/{id}")
    public NinjaModel ninjaPorId(@PathVariable Long id) {
        return ninjaService.ninjaPorId(id);
    }

    @PutMapping("/atualizar")
    public String atualizarNinja() {
        return "Ninja com id  atualizado";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaID(@PathVariable Long id) {
        ninjaService.deletarNinjaID(id);
    }

}