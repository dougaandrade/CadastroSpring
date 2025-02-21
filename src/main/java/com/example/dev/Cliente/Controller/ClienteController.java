package com.example.dev.Cliente.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.Cliente.DTO.ClienteDTO;
import com.example.dev.Cliente.Service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    protected ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/bemvindo")
    @Operation(summary = "Bem vindo ao Cadastro de Clientes", description = "Rota de boas vindas")
    public String BoasVindas() {
        return "Bem vindo ao Cadastro de Clientes";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo cliente", description = "Rota cria um novo cliente e insere no banco de dados")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente) {
        ClienteDTO clienteDTO = clienteService.criarNovoCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado com sucesso " + clienteDTO.getNome() + " com ID: " + clienteDTO.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> cliente = clienteService.listarClientes();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o cliente por Id", description = "Rota lista um cliente pelo seu id")
    public ResponseEntity<Object> clientePorId(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.clientePorId(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok().body(clienteDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o cliente por Id", description = "Rota altera um ninja pelo seu id")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        ClienteDTO clienteDTO = clienteService.atualizarClienteId(id, cliente);
        if (clienteDTO != null) {
            return ResponseEntity.ok().body("Cliente com ID " + id + " atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarClienteID(@PathVariable Long id) {
        if (clienteService.clientePorId(id) != null) {
            clienteService.deletarClienteID(id);
            return ResponseEntity.ok().body("Cliente com ID " + id + " deletado com sucesso" + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com ID " + id + " não encontrado");
        }
    }

}