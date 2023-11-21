package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Location;
import com.tobeto.rentACar.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
public class LocationsController {

    private final LocationRepository locationRepository;

    public LocationsController(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    @GetMapping
    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    @GetMapping("{id}")
    public Location getById(@PathVariable int id){
        return locationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Location location){
        locationRepository.save(location);
    }

    @PutMapping
    public void update(@RequestBody Location location){
        Location locationToUpdate = locationRepository.findById(location.getId()).orElseThrow();
        locationToUpdate.setCity(location.getCity());
        locationToUpdate.setBranchOffice(location.getBranchOffice());
        locationToUpdate.setOfficePhone(location.getOfficePhone());
        locationToUpdate.setEmployees(location.getEmployees());
        locationToUpdate.setRentalDetailsLocationPickup(location.getRentalDetailsLocationPickup());
        locationToUpdate.setRentalDetailsLocationDelivery(location.getRentalDetailsLocationDelivery());
        locationRepository.save(locationToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        locationRepository.deleteById(id);
    }

}
