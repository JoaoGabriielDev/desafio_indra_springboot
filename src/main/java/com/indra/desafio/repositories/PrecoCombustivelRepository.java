package com.indra.desafio.repositories;

import com.indra.desafio.entities.PrecoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoCombustivelRepository extends JpaRepository<PrecoCombustivel, Long> {
}
