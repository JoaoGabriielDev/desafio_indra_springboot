package com.indra.desafio.resources;

import com.indra.desafio.entities.historicoPrecoCombustivel;
import com.indra.desafio.services.historicoPrecoCombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/historicos")
public class historicoPrecoCombustivelResource {

    @Autowired
    private historicoPrecoCombustivelService service;

    public historicoPrecoCombustivelResource(historicoPrecoCombustivelService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<historicoPrecoCombustivel>> findAll(){
        List<historicoPrecoCombustivel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<historicoPrecoCombustivel> findById(@PathVariable Long id){
        historicoPrecoCombustivel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<historicoPrecoCombustivel> insert(@PathVariable Long id, @RequestBody historicoPrecoCombustivel obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<historicoPrecoCombustivel> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<historicoPrecoCombustivel> update(@PathVariable Long id, @RequestBody historicoPrecoCombustivel obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/agrupado-por-distribuidora")
    public ResponseEntity<Map<String, List<historicoPrecoCombustivel>>> getHistoricoAgrupadoPorDistribuidora() {
        Map<String, List<historicoPrecoCombustivel>> historicoAgrupado = service.getHistoricoAgrupadoPorDistribuidora();
        return ResponseEntity.ok(historicoAgrupado);
    }
}
