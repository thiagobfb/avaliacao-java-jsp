package com.thiagobfb.avaliacaojavajsp.controller;


import com.thiagobfb.avaliacaojavajsp.domain.Pessoa;
import com.thiagobfb.avaliacaojavajsp.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = service.findAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Pessoa pessoa) {
        Pessoa obj = service.insert(pessoa);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        pessoa.setId(id);
        Pessoa obj = service.update(pessoa);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> find(@PathVariable Long id) {
        Pessoa pessoa = service.find(id);
        return ResponseEntity.ok().body(pessoa);
    }

}
