package com.indra.desafio.services;

import com.indra.desafio.entities.historicoPrecoCombustivel;
import com.indra.desafio.repositories.HistoricoPrecoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class historicoPrecoCombustivelService {

    @Autowired
    private HistoricoPrecoCombustivelRepository repository;

    public historicoPrecoCombustivelService (HistoricoPrecoCombustivelRepository repository){
        this.repository = repository;
    }

    public List<historicoPrecoCombustivel> findAll(){
        return repository.findAll();
    }

    public historicoPrecoCombustivel findById(Long id){
        Optional<historicoPrecoCombustivel> obj = repository.findById(id);
        return obj.get();
    }

    public historicoPrecoCombustivel insert(historicoPrecoCombustivel obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public historicoPrecoCombustivel update(Long id, historicoPrecoCombustivel obj){
        historicoPrecoCombustivel entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(historicoPrecoCombustivel entity, historicoPrecoCombustivel obj) {
        entity.setDistribuidor(obj.getDistribuidor());
    }

    public Map<String, List<historicoPrecoCombustivel>> getHistoricoAgrupadoPorDistribuidora() {
        List<historicoPrecoCombustivel> historicoPrecos = repository.findAll();
        return historicoPrecos.stream()
                .collect(Collectors.groupingBy(historicoPrecoCombustivel::getDistribuidor));
    }

}
