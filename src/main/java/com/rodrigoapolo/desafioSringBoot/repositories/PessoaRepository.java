package com.rodrigoapolo.desafioSringBoot.repositories;

import com.rodrigoapolo.desafioSringBoot.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
