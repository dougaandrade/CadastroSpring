package com.example.dev.Ninjas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.Ninjas.Model.NinjaModel;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

}
