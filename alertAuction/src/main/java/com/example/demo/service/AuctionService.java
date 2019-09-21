package com.example.demo.service;

import com.example.demo.data.model.Auction;

public interface AuctionService {

    Iterable<Auction> findAll();
    Auction findById(int id);
    Auction save (Auction auction);
    Auction update (int id, Auction auction);
    Boolean delete (int id);
}
