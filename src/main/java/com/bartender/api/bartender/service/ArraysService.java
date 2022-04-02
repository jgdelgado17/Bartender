package com.bartender.api.bartender.service;

import java.util.Optional;

import com.bartender.api.bartender.model.Arrayss;
import com.bartender.api.bartender.repository.ArraysRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Gestiona las operaciones de negocio (agregador)
 * 
 * @author Gabriel Delgado
 */
@Service
public class ArraysService {
    @Autowired
    private ArraysRepository repoArrays;

    public Optional<Arrayss> findById(Integer id){
        return repoArrays.findById(id);
    }
}
