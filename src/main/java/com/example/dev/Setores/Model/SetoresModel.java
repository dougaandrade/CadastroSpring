package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
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

    @Column(name = "setor")
    @Embedded
    private Setor setor;

    @Column(name = "descricao")
    @Embedded
    private Descricao descricao;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Ignorar o relacionamento com os funcionários na serialização
    private List<FuncionariosModel> funcionarios;
}
