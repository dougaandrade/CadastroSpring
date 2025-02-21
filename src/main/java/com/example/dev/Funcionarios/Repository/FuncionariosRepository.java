package com.example.dev.Funcionarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Funcionarios.Model.FuncionariosModel;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {

}
