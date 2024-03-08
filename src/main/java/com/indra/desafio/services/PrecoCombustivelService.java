package com.indra.desafio.services;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.repositories.PrecoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrecoCombustivelService {

    @Autowired
    private PrecoCombustivelRepository repository;

    public PrecoCombustivelService(PrecoCombustivelRepository repository) {
        this.repository = repository;
    }

    public List<PrecoCombustivel> findAll(){
        return repository.findAll();
    }
    public PrecoCombustivel findById(Long id){
        Optional<PrecoCombustivel> obj = repository.findById(id);
        return obj.get();
    }

    public double calcularMediaPrecoPorMunicipio(String municipio){
        List<PrecoCombustivel> precos = repository.findByMunicipio(municipio);
        double soma = precos.stream().mapToDouble(PrecoCombustivel::getPreco).sum();
        return soma / precos.size();
    }

    public List<PrecoCombustivel> obterPrecosPorRegiao(String regiao){
        return repository.findByRegiao(regiao);
    }

    public Map<Instant, List<PrecoCombustivel>> obterPrecosAgrupadosPorDataColeta() {
        List<PrecoCombustivel> precos = repository.findAll();
        return precos.stream()
                .collect(Collectors.groupingBy(PrecoCombustivel::getDataColeta));
    }
}
