package com.rodrigoapolo.desafioSringBoot.services;

import com.rodrigoapolo.desafioSringBoot.entities.Pessoa;
import com.rodrigoapolo.desafioSringBoot.repositories.PessoaRepository;
import com.rodrigoapolo.desafioSringBoot.services.exceptions.DatabaseException;
import com.rodrigoapolo.desafioSringBoot.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa findById(Long id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pessoa insert(Pessoa obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Pessoa update(Long id, Pessoa obj){
        try {
            Pessoa entity = repository.getReferenceById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(Pessoa entity, Pessoa obj) {
        entity.setName(obj.getName());
        entity.setDataNascimento(obj.getDataNascimento());
    }


}
