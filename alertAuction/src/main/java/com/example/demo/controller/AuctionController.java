package com.example.demo.controller;

import com.example.demo.data.model.Auction;
import com.example.demo.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Auction>> findAll () {
        return ResponseEntity.ok(this.auctionService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Auction> findById (@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(this.auctionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Auction> getAll (@RequestBody Auction auction) {
        return new ResponseEntity<Auction>(this.auctionService.save(auction), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Auction> getAll (@PathVariable(name = "id") int id, @RequestBody Auction auction) {
        return ResponseEntity.ok(this.auctionService.update(id, auction));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable(name = "id") int id) {
        Boolean response = this.auctionService.delete(id);
        if (!response) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
