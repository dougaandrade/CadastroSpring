package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Funcionarios.Model.FuncionariosModel;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Long id;
    @Column(unique = true, name = "nome_setor")
    private String setor;
    @Column(name = "descricao_setor")
    private String descricao;

    // @OneToMany um setor tem varios funcionarios (UM PARA MUITOS RELACAO)
    @OneToMany(mappedBy = "setor")
    @JsonIgnore
    private List<FuncionariosModel> funcionarios;

}