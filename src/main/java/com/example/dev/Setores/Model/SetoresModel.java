package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Setores.Exceptions.IdCriadoException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_setores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetoresModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "setor")
    private String setor;
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "setor")
    @JsonIgnore // Ignorar o relacionamento com os funcionários
    private List<FuncionariosModel> funcionarios;

}