package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Estacionamento;
import com.example.demo.data.repository.EstacionamentoRepository;
import com.example.demo.service.EstacionamentoService;

@Service
public class EstacionamentoServiceImpl implements EstacionamentoService {

    EstacionamentoRepository estabelecimentoRepository;

    @Autowired
    public EstacionamentoServiceImpl(EstacionamentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Iterable<Estacionamento> findAll() {
        return Optional.ofNullable(estabelecimentoRepository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public Estacionamento findById(int id) {
        return estabelecimentoRepository.findById(id).get();
    }

    @Override
    public Estacionamento save(Estacionamento estabelecimento) {
        return estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public Estacionamento update(int id, Estacionamento estabelecimento) {
        if (estabelecimentoRepository.findById(id).get() == null) {
            return null;
        }
        estabelecimento.setId(id);
        return estabelecimentoRepository.save(estabelecimento);
    }

    @Override
    public Boolean delete(int id) {
    	Estacionamento entity = estabelecimentoRepository.findById(id).orElse(null);

        if (entity == null) {
            return false;
        }
        estabelecimentoRepository.delete(entity);
        return true;
    }
}
