package com.example.dev.Funcionarios.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
import com.example.dev.Funcionarios.Service.FuncionariosService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/func")
public class FuncionariosController {

    protected FuncionariosService funcionariosService;

    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo funcionario", description = "Rota cria um novo funcionario e insere no banco de dados")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionariosDTO funcionario) {
        FuncionariosDTO funcionarioDTO = funcionariosService.criarNovoFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso " + funcionarioDTO.getNome() + " com ID: "
                        + funcionarioDTO.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionariosDTO>> listarFuncionarios() {
        List<FuncionariosDTO> funcionario = funcionariosService.listarFuncionarios();
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o funcionario por Id", description = "Rota lista um funcionario pelo seu id")
    public ResponseEntity<Object> funcionarioPorId(@PathVariable Long id) {
        FuncionariosDTO funcionarioDTO = funcionariosService.funcionariosPorId(id);
        if (funcionarioDTO != null) {
            return ResponseEntity.ok().body(funcionarioDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não encontrado");
        }
    }

    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Altera o funcionario por Id", description = "Rota altera um funcionario pelo seu id")
    public ResponseEntity<String> atualizarFuncionarioId(@PathVariable Long id,
            @RequestBody FuncionariosDTO funcionarios) {
        FuncionariosDTO funcionariosDTO = funcionariosService.atualizarFuncionarioId(id, funcionarios);
        if (funcionariosDTO != null) {
            return ResponseEntity.ok().body("Funcionario com ID " + id + " atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionarioID(@PathVariable Long id) {
        if (funcionariosService.funcionariosPorId(id) != null) {
            funcionariosService.deletarFuncionarioID(id);
            return ResponseEntity.ok().body("Funcionario com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario com ID " + id + " não encontrado");
        }
    }

}