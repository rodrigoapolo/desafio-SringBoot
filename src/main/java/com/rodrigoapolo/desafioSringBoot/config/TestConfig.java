package com.rodrigoapolo.desafioSringBoot.config;

import com.rodrigoapolo.desafioSringBoot.entities.Endereco;
import com.rodrigoapolo.desafioSringBoot.entities.Pessoa;
import com.rodrigoapolo.desafioSringBoot.entities.enums.EnderecoStatus;
import com.rodrigoapolo.desafioSringBoot.repositories.EnderecoRepository;
import com.rodrigoapolo.desafioSringBoot.repositories.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {
        Pessoa u1 = new Pessoa(null, "Maria Brown", Instant.parse("2000-06-20T19:53:07Z"));
        Pessoa u2 = new Pessoa(null, "Alex Green", Instant.parse("1990-07-22T15:21:22Z"));

        Endereco end1 = new Endereco(null, "Avenida Paulista","01310-200", "2456", "São Paulo", u1, EnderecoStatus.SECONDARY);
        Endereco end2 = new Endereco(null, "Avenida Brigadeiro Faria Lima","05426200", "546", "São Paulo", u2 , EnderecoStatus.MAIN);
        Endereco end3 = new Endereco(null, "Avenida Jacu-Pêssego","08215115", "654", "São Paulo", u1, EnderecoStatus.MAIN);

        pessoaRepository.saveAll(Arrays.asList(u1, u2));
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

    }
}
