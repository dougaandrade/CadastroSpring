package com.example.dev.Setores.Model;

import java.util.List;

import com.example.dev.Enum.StatusSetor;
import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_setores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SetoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    private String setor;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusSetor status;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Ignorar o relacionamento com os funcionários na serialização
    private List<FuncionariosModel> funcionarios;

}
