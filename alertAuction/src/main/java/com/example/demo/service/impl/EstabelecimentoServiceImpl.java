package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Estabelecimento;
import com.example.demo.data.repository.EstabelecimentoRepository;
import com.example.demo.service.EstabelecimentoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    public EstabelecimentoServiceImpl(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Iterable<Estabelecimento> findAll() {
        return Optional.ofNullable(estabelecimentoRepository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public Estabelecimento findById(int id) {
        Optional<Estabelecimento> findById = estabelecimentoRepository.findById(id);
        if(!findById.isPresent()){
        	return null;
        }
		return findById.get();
    }

    @Override
    public Estabelecimento save(Estabelecimento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public Estabelecimento update(int id, Estabelecimento estabelecimento) {
        if (estabelecimentoRepository.findById(id).get() == null) {
            return null;
        }
        estabelecimento.setId(id);
        return estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public Boolean delete(int id) {
    	Estabelecimento entity = estabelecimentoRepository.findById(id).orElse(null);

        if (entity == null) {
            return false;
        }
        estabelecimentoRepository.delete(entity);
        return true;
    }
}
