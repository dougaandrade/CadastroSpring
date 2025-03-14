package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_setores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotNull(message = "O setor é obrigatório")
    @Size(min = 2, max = 100, message = "O setor deve ter entre 2 e 100 caracteres")
    private String setor;

    @NotNull(message = "A descrição do setor é obrigatória")
    @Size(min = 5, max = 255, message = "A descrição deve ter entre 5 e 255 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotEmpty(message = "O setor deve conter pelo menos um funcionário")
    @JsonIgnore // Ignorar o relacionamento com os funcionários na serialização
    private List<FuncionariosModel> funcionarios;
}
