package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    public final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository){
        this.rentalRepository=rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @PutMapping
    public void update(@RequestBody Rental rental){
        Rental rentalToUpdate = rentalRepository.findById(rental.getId()).orElseThrow();
        rentalToUpdate.setCar(rental.getCar());
        rentalToUpdate.setUser(rental.getUser());
        rentalToUpdate.setInvoice(rental.getInvoice());
        rentalToUpdate.setRentalDetail(rental.getRentalDetail());
        rentalRepository.save(rentalToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalRepository.deleteById(id);
    }

}
