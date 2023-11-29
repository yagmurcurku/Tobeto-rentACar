package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.LocationService;
import com.tobeto.rentACar.services.dtos.requests.location.AddLocationRequest;
import com.tobeto.rentACar.services.dtos.requests.location.UpdateLocationRequest;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationListResponse;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationResponse;
import com.tobeto.rentACar.entities.Location;
import com.tobeto.rentACar.repositories.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/locations")
@AllArgsConstructor
public class LocationsController {

    private final LocationService locationService;

    @GetMapping
    public List<GetLocationListResponse> getAll(){
        return locationService.getAll();
    }

    @GetMapping("{id}")
    public GetLocationResponse getById(@PathVariable int id){
        return locationService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddLocationRequest addLocationRequest){
        locationService.add(addLocationRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateLocationRequest updateLocationRequest){
        locationService.update(updateLocationRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        locationService.delete(id);
    }

}
