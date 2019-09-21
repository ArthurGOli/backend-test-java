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

import com.example.demo.data.model.Estacionamento;
import com.example.demo.service.EstacionamentoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    EstacionamentoService estacionamentoService;

    @Autowired
    public EstacionamentoController(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Estacionamento>> findAll () {
        return ResponseEntity.ok(this.estacionamentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estacionamento> findById (@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(this.estacionamentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Estacionamento> getAll (@RequestBody Estacionamento estacionamento) {
        return new ResponseEntity<Estacionamento>(this.estacionamentoService.save(estacionamento), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estacionamento> getAll (@PathVariable(name = "id") int id, @RequestBody Estacionamento estacionamento) {
        return ResponseEntity.ok(this.estacionamentoService.update(id, estacionamento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable(name = "id") int id) {
        Boolean response = this.estacionamentoService.delete(id);
        if (!response) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
