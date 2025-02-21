package com.example.dev.Cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Cliente.Model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
