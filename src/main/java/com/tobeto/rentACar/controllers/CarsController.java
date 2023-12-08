package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarResponse;
import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest addCarRequest){
        carService.add(addCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        carService.update(updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }

    @GetMapping("/getAllCars")
    public List<GetByCarListResponse> getAllCars(){
        return carService.getAllCars();
    }


    @GetMapping("/getByPrice")
    public List<GetByCarListResponse> getByCarListResponses(@RequestParam double min, @RequestParam double max){
        return carService.findCarByDailyPriceBetween(min,max);
    }

    @GetMapping("/getByStateTrue")
    public List<GetByCarListResponse> getByCarStateTrue(){
        return carService.getByStateTrue();
    }


    @GetMapping("/getByState")
    public List<GetByCarListResponse> getByCarState(@RequestParam boolean state){
        return carService.getByState(state);
    }


}

