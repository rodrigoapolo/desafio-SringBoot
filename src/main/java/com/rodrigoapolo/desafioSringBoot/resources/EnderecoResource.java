package com.rodrigoapolo.desafioSringBoot.resources;

import com.rodrigoapolo.desafioSringBoot.entities.Endereco;
import com.rodrigoapolo.desafioSringBoot.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable long id){
        Endereco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Set<Endereco>> addressPersonal(@PathVariable long id){
        Set<Endereco> obj = service.addressPersonal(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/pessoaMain/{id}")
    public ResponseEntity<Endereco> addressMain(@PathVariable long id){
        Endereco obj = service.addressMain(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable long id, @RequestBody Endereco obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
