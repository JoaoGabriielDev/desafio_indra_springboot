package com.indra.desafio.config;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.entities.User;

import com.indra.desafio.entities.historicoPrecoCombustivel;
import com.indra.desafio.repositories.HistoricoPrecoCombustivelRepository;
import com.indra.desafio.repositories.PrecoCombustivelRepository;
import com.indra.desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoricoPrecoCombustivelRepository historicoPrecoCombustivelRepository;

    @Autowired
    private PrecoCombustivelRepository precoCombustivelRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "987809368", "123456");
        User u2 = new User(null, "Alex Green", "alexgreen@gmail.com", "947204835", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        PrecoCombustivel p1 = new PrecoCombustivel(null, "Joao Pessoa", "Nordeste" , "Shell", "Gasolina", Instant.parse("2024-03-06T15:21:22Z"), 2.00, 4.00 );
        PrecoCombustivel p2 = new PrecoCombustivel(null, "Sao Paulo", "Suldeste", "Petrobras", "Alcool", Instant.parse("2024-02-10T10:20:10Z"), 4.00, 6.00);
        PrecoCombustivel p3 = new PrecoCombustivel(null, "Joao Pessoa", "Nordeste", "Shell",  "Alcool", Instant.parse("2024-02-10T12:00:10Z"), 6.00, 8.00);
        PrecoCombustivel p4 = new PrecoCombustivel(null, "Joao Pessoa", "Nordeste", "Shell", "Gasolina", Instant.parse("2024-03-10T12:00:10Z"), 2.00, 6.00);

        precoCombustivelRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        historicoPrecoCombustivel h1 = new historicoPrecoCombustivel(null, "A", u1, p1);
        historicoPrecoCombustivel h2 = new historicoPrecoCombustivel(null, "B", u2, p2);
        historicoPrecoCombustivel h3 = new historicoPrecoCombustivel(null, "A", u1, p3);
        historicoPrecoCombustivel h4 = new historicoPrecoCombustivel(null, "B", u2, p4);

        historicoPrecoCombustivelRepository.saveAll(Arrays.asList(h1, h2, h3, h4));
    }
}
