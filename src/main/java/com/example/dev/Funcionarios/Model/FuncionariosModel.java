package com.example.dev.Funcionarios.Model;

import java.time.LocalDate;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

    @NotNull
    @Embedded
    private Nome nome;

    @NotNull
    @Embedded
    private Email email;

    @NotNull
    @Min(value = 18)
    @Column(name = "idade", nullable = false)
    private int idade;

    @NotNull
    @Embedded
    private Cpf cpf;

    @Past
    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private SetoresModel setor;
}
