package com.example.demo.service;

import com.example.demo.data.model.Estabelecimento;

public interface EstabelecimentoService {
	
	Iterable<Estabelecimento> findAll();
	Estabelecimento findById(int id);
	Estabelecimento save (Estabelecimento estabelecimento);
	Estabelecimento update (int id, Estabelecimento estabelecimento);
    Boolean delete (int id);

}
