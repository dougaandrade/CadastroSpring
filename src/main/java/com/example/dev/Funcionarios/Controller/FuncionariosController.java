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

import com.example.dev.Funcionarios.DTO.FuncionariosRequest.FuncionariosRequest;
import com.example.dev.Funcionarios.DTO.FuncionariosResponse.FuncionariosResponse;
import com.example.dev.Funcionarios.Service.FuncionariosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class FuncionariosController {

    private final FuncionariosService funcionariosService;

    @PostMapping
    @Operation(summary = "Cria um novo funcionario", description = "Rota cria um novo funcionario e insere no banco de dados")
    public ResponseEntity<FuncionariosResponse> criarFuncionario(@Valid @RequestBody FuncionariosRequest funcionario) {
        FuncionariosResponse criado = funcionariosService.criarNovoFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionariosResponse>> listarFuncionarios() {
        return ResponseEntity.ok(funcionariosService.listarFuncionarios());
    }

    @GetMapping("/obter/{codFuncionario}")
    public ResponseEntity<FuncionariosResponse> funcionarioPorId(@PathVariable Long codFuncionario) {
        return funcionariosService.funcionariosByCod(codFuncionario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/alterar/{codFuncionario}")
    public ResponseEntity<FuncionariosResponse> atualizarFuncionarioId(
            @PathVariable Long codFuncionario,
            @RequestBody FuncionariosResponse funcionarios) {
        FuncionariosResponse atualizado = funcionariosService.atualizarFuncionarioByCod(codFuncionario, funcionarios);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/deletar/{codFuncionario}")
    public ResponseEntity<String> deletarFuncionarioByCod(@PathVariable Long codFuncionario) {
        funcionariosService.deletarFuncionarioCod(codFuncionario);
        return ResponseEntity.ok("Funcionário com o código " + codFuncionario + " deletado com sucesso");
    }
}
