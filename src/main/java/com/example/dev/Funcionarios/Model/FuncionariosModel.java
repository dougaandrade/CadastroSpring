package com.example.dev.Funcionarios.Model;

import java.time.LocalDate;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "O e-mail é obrigatório")
    @Email
    private String email;

    @NotNull
    @Min(value = 18, message = "A idade deve ser maior ou igual a 18")
    @Column(name = "idade", nullable = false)
    private int idade;

    @Embedded
    private Cpf cpf;

    @Past
    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @NotNull(message = "O setor é obrigatório")
    @JoinColumn(name = "setor_id", nullable = false)
    private SetoresModel setor;
}
