package com.example.demo.service;

import com.example.demo.data.model.Estacionamento;

public interface EstacionamentoService {
	
	Iterable<Estacionamento> findAll();
	Estacionamento findById(int id);
	Estacionamento save (Estacionamento estacionamento);
	Estacionamento update (int id, Estacionamento estacionamento);
    Boolean delete (int id);

}
