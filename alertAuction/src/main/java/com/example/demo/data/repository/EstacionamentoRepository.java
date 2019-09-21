package com.example.demo.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Estacionamento;

@Repository
public interface EstacionamentoRepository extends CrudRepository<Estacionamento, Integer> {

}
