package com.example.dev.Missoes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Missoes.Model.MissoesModel;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}