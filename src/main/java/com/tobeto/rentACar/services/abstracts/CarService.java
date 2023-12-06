package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {

    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest addCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
    List<GetByCarListResponse> getAllCars();

    List<GetByCarListResponse> findCarByDailyPriceBetween(Double min, Double max);

}
