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

import com.example.demo.data.model.Veiculo;
import com.example.demo.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Veiculo>> findAll () {
        return ResponseEntity.ok(this.veiculoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Veiculo> findById (@PathVariable(name = "id") int id) {
        Veiculo veiculoReturn = this.veiculoService.findById(id);
        if(veiculoReturn == null) {
        	return new ResponseEntity<Veiculo>(HttpStatus.NOT_FOUND);
        }
		return ResponseEntity.ok(veiculoReturn);
    }

    @PostMapping
    public ResponseEntity<Veiculo> getAll (@RequestBody Veiculo veiculo) {
        return new ResponseEntity<Veiculo>(this.veiculoService.save(veiculo), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Veiculo> getAll (@PathVariable(name = "id") int id, @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(this.veiculoService.update(id, veiculo));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable(name = "id") int id) {
        Boolean response = this.veiculoService.delete(id);
        if (!response) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
