package com.example.dev.Funcionarios.Model;

import java.time.LocalDate;
import java.util.UUID;

import com.example.dev.Setores.Model.SetoresModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "setor")
public class FuncionariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cod_funcionario")
    private Long codFuncionario;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private SetoresModel setor;

    @PrePersist
    public void gerarCodigo() {
        this.codFuncionario = (long) (Math.abs(UUID.randomUUID().hashCode() % 9000) + 1000); // Garante 4 dígitos
    }

}