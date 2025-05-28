package com.example.dev.Funcionarios.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Setores.Model.SetoresModel;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {

  Optional<FuncionariosModel> findByCodFuncionario(Long codFuncionario);

  Optional<FuncionariosModel> findByEmail(String email);

  Optional<FuncionariosModel> findBySetor(SetoresModel setor);

  Optional<FuncionariosModel> findByCpf(Cpf cpf);

}
