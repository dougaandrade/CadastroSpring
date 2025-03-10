package com.example.dev.Funcionarios.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Funcionarios.Model.Email;
import com.example.dev.Funcionarios.Model.FuncionariosModel;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {

  Optional<FuncionariosModel> findByNome(String nome);

  Optional<FuncionariosModel> findByCodFuncionario(Long codFuncionario);

  Optional<FuncionariosModel> findByEmail(Email email);

}
