package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Auction;
import com.example.demo.data.repository.AuctionRepository;
import com.example.demo.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {

    AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Iterable<Auction> findAll() {
        return Optional.ofNullable(auctionRepository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public Auction findById(int id) {
        return auctionRepository.findById(id).get();
    }

    @Override
    public Auction save(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction update(int id, Auction auction) {
        if (auctionRepository.findById(id).get() == null) {
            return null;
        }
        auction.setId(id);
        return auctionRepository.save(auction);
    }

    @Override
    public Boolean delete(int id) {
        Auction entity = auctionRepository.findById(id).orElse(null);

        if (entity == null) {
            return false;
        }
        auctionRepository.delete(entity);
        return true;
    }
}
