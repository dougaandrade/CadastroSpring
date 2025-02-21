package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Cliente.Model.ClienteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Long id;
    private String nomeSetor;
    private String descricaoSetor;

    // @OneToMany uma missao tem varios ninjas (UM PARA MUITOS NINJAS)
    @OneToMany(mappedBy = "setores")
    @JsonIgnore
    private List<ClienteModel> clientes;

}