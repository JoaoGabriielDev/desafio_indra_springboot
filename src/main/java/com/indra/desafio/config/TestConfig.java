package com.indra.desafio.config;

import com.indra.desafio.entities.User;
import com.indra.desafio.entities.historicoPrecoCombustivel;
import com.indra.desafio.repositories.HistoricoPrecoCombustivelRepository;
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


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "987809368", "123456");
        User u2 = new User(null, "Alex Green", "alexgreen@gmail.com", "947204835", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        historicoPrecoCombustivel h1 = new historicoPrecoCombustivel(null, "Joao Pessoa", "Litoral-Mata",
                "A", Instant.parse("2024-06-21T15:21:22Z"), "Gasolina", "Shell",
                4.5, 5.0);

        historicoPrecoCombustivel h2 = new historicoPrecoCombustivel(null, "Campina Grande", "Agreste-Brejo",
                "B", Instant.parse("2024-07-05T16:10:15Z"), "Alcool", "Petrobras",
                2.5, 3.0);

        historicoPrecoCombustivelRepository.saveAll(Arrays.asList(h1, h2));



    }
}
