package com.example.dev.Funcionarios.Model;

import java.time.LocalDate;
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

    @Embedded
    @Column(unique = true)
    private Email email;

    @Column(name = "idade")
    private int idade;
    @Embedded
    @Column(name = "cpf")
    private Cpf cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private SetoresModel setor;

}