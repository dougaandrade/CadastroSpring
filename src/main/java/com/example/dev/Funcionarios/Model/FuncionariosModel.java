package com.example.dev.Funcionarios.Model;

import java.time.LocalDate;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "setor")
@Builder
public class FuncionariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionario")
    private Long codFuncionario;

    private String nome;

    private String email;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Embedded
    private Cpf cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private SetoresModel setor;
}
