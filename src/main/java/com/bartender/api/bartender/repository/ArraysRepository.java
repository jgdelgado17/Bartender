package com.bartender.api.bartender.repository;

import com.bartender.api.bartender.model.Arrayss;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Mecanismo de encapsulación para las operaciones CRUD
 * @author Gabriel Delgado
 */
public interface ArraysRepository extends JpaRepository<Arrayss,Integer> {
    
}
