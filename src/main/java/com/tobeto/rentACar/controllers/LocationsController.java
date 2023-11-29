package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.dtos.requests.location.AddLocationRequest;
import com.tobeto.rentACar.services.dtos.requests.location.UpdateLocationRequest;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationListResponse;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationResponse;
import com.tobeto.rentACar.entities.Location;
import com.tobeto.rentACar.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/locations")
public class LocationsController {

    private final LocationRepository locationRepository;

    public LocationsController(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    @GetMapping
    public List<GetLocationListResponse> getAll(){
        List<Location> locationList = locationRepository.findAll();
        List<GetLocationListResponse> locationListResponses = new ArrayList<GetLocationListResponse>();
        for (Location location: locationList) {
            GetLocationListResponse locationResponse = new GetLocationListResponse();
            locationResponse.setId(location.getId());
            locationResponse.setCity(location.getCity());
            locationResponse.setBranchOffice(location.getBranchOffice());
            locationResponse.setOfficePhone(location.getOfficePhone());
            locationListResponses.add(locationResponse);
        }
        return locationListResponses;
    }

    @GetMapping("{id}")
    public GetLocationResponse getById(@PathVariable int id){
        Location location = locationRepository.findById(id).orElseThrow();
        GetLocationResponse dto = new GetLocationResponse();
        dto.setCity(location.getCity());
        dto.setBranchOffice(location.getBranchOffice());
        dto.setOfficePhone(location.getOfficePhone());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddLocationRequest addLocationRequest){
        Location location = new Location();
        location.setCity(addLocationRequest.getCity());
        location.setBranchOffice(addLocationRequest.getBranchOffice());
        location.setOfficePhone(addLocationRequest.getOfficePhone());
        locationRepository.save(location);
    }

    @PutMapping
    public void update(@RequestBody UpdateLocationRequest updateLocationRequest){
        Location locationToUpdate = locationRepository.findById(updateLocationRequest.getId()).orElseThrow();
        locationToUpdate.setCity(updateLocationRequest.getCity());
        locationToUpdate.setBranchOffice(updateLocationRequest.getBranchOffice());
        locationToUpdate.setOfficePhone(updateLocationRequest.getOfficePhone());
        locationRepository.save(locationToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        locationRepository.deleteById(id);
    }

}
