package com.example.dev.Funcionarios.Controller;

import java.util.List;
import java.util.Optional;

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
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class FuncionariosController {

    protected FuncionariosService funcionariosService;

    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo funcionario", description = "Rota cria um novo funcionario e insere no banco de dados")
    public ResponseEntity<String> criarFuncionario(@Valid @RequestBody FuncionariosDTO funcionario) {
        funcionariosService.criarNovoFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso ");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionariosDTO>> listarFuncionarios() {
        List<FuncionariosDTO> funcionario = funcionariosService.listarFuncionarios();
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/obter/{codFuncionario}")
    @Operation(summary = "Lista o funcionario por Id", description = "Rota lista um funcionario pelo seu id")
    public ResponseEntity<Object> funcionarioPorId(@PathVariable Long codFuncionario) {
        Optional<FuncionariosDTO> funcionarioDTO = funcionariosService.funcionariosByCod(codFuncionario);
        return ResponseEntity.ok().body(funcionarioDTO);
    }

    @PatchMapping("/alterar/{codFuncionario}")
    @Operation(summary = "Altera o funcionario por Id", description = "Rota altera um funcionario pelo seu id")
    public ResponseEntity<String> atualizarFuncionarioId(
            @Valid @PathVariable Long codFuncionario,
            @RequestBody FuncionariosDTO funcionarios) {
        FuncionariosDTO funcionariosDTO = funcionariosService.atualizarFuncionarioByCod(codFuncionario, funcionarios);
        if (funcionariosDTO != null) {
            return ResponseEntity.ok().body("Funcionario " + codFuncionario + " atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionario " + codFuncionario + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{codFuncionario}")
    public ResponseEntity<String> deletarFuncionarioByCod(@PathVariable Long codFuncionario) {
        funcionariosService.deletarFuncionarioCod(codFuncionario);
        return ResponseEntity.ok().body("Funcionario com o nome " + codFuncionario + " deletado com sucesso");
    }

}