package com.example.dev.Ninjas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + ninjaDTO.getNome() + " com ID: " + ninjaDTO.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ninjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.ninjaPorId(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok().body(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
        if (ninjaDTO != null) {
            return ResponseEntity.ok().body("Ninja com ID " + id + " atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaID(@PathVariable Long id) {
        if (ninjaService.ninjaPorId(id) != null) {
            ninjaService.deletarNinjaID(id);
            return ResponseEntity.ok().body("Ninja com ID " + id + " deletado com sucesso" + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado");
        }
    }

}