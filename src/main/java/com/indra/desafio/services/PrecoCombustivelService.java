package com.indra.desafio.services;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.repositories.PrecoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecoCombustivelService {

    @Autowired
    private PrecoCombustivelRepository repository;

    public List<PrecoCombustivel> findAll(){
        return repository.findAll();
    }
    public PrecoCombustivel findById(Long id){
        Optional<PrecoCombustivel> obj = repository.findById(id);
        return obj.get();
    }
}
