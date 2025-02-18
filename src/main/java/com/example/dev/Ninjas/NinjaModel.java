package com.example.dev.Ninjas;



import com.example.dev.Missoes.MissoesModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Transformar classe em entidade no banco 
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor // construtor padrão
@AllArgsConstructor // construtor com parâmetros

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String email;

    private int idade;

    //  @ManyToOne um ninja tem uma unica relação com missoes  (MUITOS para UMA Missão)
    @ManyToOne
    @JoinColumn(name = "missoes_id") // chave estrangeira
    private MissoesModel missoes;

}