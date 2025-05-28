package com.example.dev.Setores.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Setores.Model.SetoresModel;

public interface SetoresRepository extends JpaRepository<SetoresModel, Long> {

  Optional<SetoresModel> findBySetor(String setor);


}