package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Veiculo;
import com.example.demo.data.repository.VeiculoRepository;
import com.example.demo.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Iterable<Veiculo> findAll() {
        return Optional.ofNullable(veiculoRepository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public Veiculo findById(int id) {
        Optional<Veiculo> findById = veiculoRepository.findById(id);
        if(!findById.isPresent()) {
        	return null;
        }
		return findById.get();
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
    	veiculo.setHrEntrada(new Date());
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo update(int id, Veiculo veiculo) {
        if (veiculoRepository.findById(id).get() == null) {
            return null;
        }
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Boolean delete(int id) {
    	Veiculo entity = veiculoRepository.findById(id).orElse(null);

        if (entity == null) {
            return false;
        }
        veiculoRepository.delete(entity);
        return true;
    }
}
