package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.model.Estabelecimento;
import com.example.demo.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    EstabelecimentoService estabelecimentoService;

    @Autowired
    public EstabelecimentoController(EstabelecimentoService estabelecimentoService) {
        this.estabelecimentoService = estabelecimentoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Estabelecimento>> findAll () {
        return ResponseEntity.ok(this.estabelecimentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estabelecimento> findById (@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(this.estabelecimentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> getAll (@RequestBody Estabelecimento estabelecimento) {
        return new ResponseEntity<Estabelecimento>(this.estabelecimentoService.save(estabelecimento), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estabelecimento> getAll (@PathVariable(name = "id") int id, @RequestBody Estabelecimento estabelecimento) {
        return ResponseEntity.ok(this.estabelecimentoService.update(id, estabelecimento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable(name = "id") int id) {
        Boolean response = this.estabelecimentoService.delete(id);
        if (!response) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
