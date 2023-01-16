package com.rodrigoapolo.desafioSringBoot.repositories;

import com.rodrigoapolo.desafioSringBoot.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
