package com.indra.desafio.resources;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.services.PrecoCombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/precoCombustivel")
public class PrecoCombustivelResource {

    @Autowired
    private PrecoCombustivelService service;

    @GetMapping
    public ResponseEntity<List<PrecoCombustivel>> findAll(){
        List<PrecoCombustivel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PrecoCombustivel> findById(@PathVariable Long id){
        PrecoCombustivel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
