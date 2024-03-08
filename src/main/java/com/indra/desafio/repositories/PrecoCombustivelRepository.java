package com.indra.desafio.repositories;

import com.indra.desafio.entities.PrecoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrecoCombustivelRepository extends JpaRepository<PrecoCombustivel, Long> {

    List<PrecoCombustivel> findByMunicipio(String municipio);

    List<PrecoCombustivel> findByRegiao(String regiao);
}
