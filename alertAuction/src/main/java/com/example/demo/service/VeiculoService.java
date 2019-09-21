package com.example.demo.service;

import com.example.demo.data.model.Veiculo;

public interface VeiculoService {
	
	Iterable<Veiculo> findAll();
	Veiculo findById(int id);
    Veiculo save (Veiculo veiculo);
    Veiculo update (int id, Veiculo veiculo);
    Boolean delete (int id);

}
