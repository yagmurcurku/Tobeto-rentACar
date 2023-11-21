package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.RentalDetail;
import com.tobeto.rentACar.repositories.RentalDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentaldetails")
public class RentalDetailController {

    private final RentalDetailRepository rentalDetailRepository;

    public RentalDetailController(RentalDetailRepository rentalDetailRepository){
        this.rentalDetailRepository=rentalDetailRepository;
    }

    @GetMapping
    public List<RentalDetail> getAll(){
        return rentalDetailRepository.findAll();
    }

    @GetMapping("{id}")
    public RentalDetail getById(@PathVariable int id){
        return rentalDetailRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody RentalDetail rentalDetail){
        rentalDetailRepository.save(rentalDetail);
    }

    @PutMapping
    public void update(@RequestBody RentalDetail rentalDetail){
        RentalDetail rentalDetailToUpdate = rentalDetailRepository.findById(rentalDetail.getId()).orElseThrow();
        rentalDetailToUpdate.setStartDate(rentalDetail.getStartDate());
        rentalDetailToUpdate.setEndDate(rentalDetail.getEndDate());
        rentalDetailToUpdate.setRental(rentalDetail.getRental());
        rentalDetailToUpdate.setLocationPickup(rentalDetail.getLocationPickup());
        rentalDetailToUpdate.setLocationDelivery(rentalDetail.getLocationDelivery());
        rentalDetailToUpdate.setEmployee(rentalDetail.getEmployee());
        rentalDetailRepository.save(rentalDetailToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailRepository.deleteById(id);
    }

}
