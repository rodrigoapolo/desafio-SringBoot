package com.rodrigoapolo.desafioSringBoot.services;

import com.rodrigoapolo.desafioSringBoot.entities.Endereco;
import com.rodrigoapolo.desafioSringBoot.entities.Pessoa;
import com.rodrigoapolo.desafioSringBoot.entities.enums.EnderecoStatus;
import com.rodrigoapolo.desafioSringBoot.repositories.EnderecoRepository;
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
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private PessoaService pessoaService;

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Endereco insert(Endereco obj){
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

    public Endereco update(Long id, Endereco obj){
        try {
            Endereco entity = repository.getReferenceById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(Endereco entity, Endereco obj) {
        entity.setLogradouro(obj.getLogradouro());
        entity.setCep(obj.getCep());
        entity.setNumero(obj.getNumero());
        entity.setCidade(obj.getCidade());

    }

    public Set<Endereco> addressPersonal (Long id){
        Pessoa p = pessoaService.findById(id);
        return p.getEnderecos();
    }

    public Endereco addressMain(Long id){
        Set<Endereco> end = addressPersonal(id);
        List<Endereco> endereco = end.stream()
                .filter(e -> e.getStatus() == EnderecoStatus.MAIN)
                .collect(Collectors.toList());

        return endereco.get(0);
    }


}
