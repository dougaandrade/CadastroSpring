package com.example.dev.Cliente.Model;

import java.sql.Timestamp;

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
@ToString(exclude = "setores")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "cpf")
    private int cpf;

    @Column(name = "data_nascimento")
    private Timestamp dataNascimento;

    @ManyToOne
    @JoinColumn(name = "setores_id")
    private SetoresModel setores;

}