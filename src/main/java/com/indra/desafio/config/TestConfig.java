package com.indra.desafio.config;

import com.indra.desafio.entities.User;
import com.indra.desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariabrown@gmail.com", "987809368", "123456");

        userRepository.saveAll(Arrays.asList(u1));

    }
}
