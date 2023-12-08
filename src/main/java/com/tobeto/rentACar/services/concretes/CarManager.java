package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.repositories.CarRepository;
import com.tobeto.rentACar.services.abstracts.CarService;
import com.tobeto.rentACar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetByModelResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetCarListResponse> carListResponses = new ArrayList<GetCarListResponse>();
        for (Car car: carList) {
            GetCarListResponse carResponse = new GetCarListResponse();
            carResponse.setId(car.getId());
            carResponse.setPlate(car.getPlate());
            carResponse.setDailyPrice(car.getDailyPrice());
            carResponse.setState(car.isState());
            carResponse.setModel(car.getModel());
            carListResponses.add(carResponse);
        }
        return carListResponses;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse dto = new GetCarResponse();
        dto.setPlate(car.getPlate());
        dto.setDailyPrice(car.getDailyPrice());
        dto.setState(car.isState());
        dto.setModel(car.getModel());
        return dto;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        if(carRepository.existsByPlate(addCarRequest.getPlate())){
            throw new RuntimeException("Bu plaka daha önce başka bir araca eklendi !");
        }
        Car car = new Car();
        car.setPlate(addCarRequest.getPlate());
        car.setDailyPrice(addCarRequest.getDailyPrice());
        car.setState(addCarRequest.isState());
        car.setModel(addCarRequest.getModel());
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car carToUpdate = carRepository.findById(updateCarRequest.getId()).orElseThrow();
        carToUpdate.setModel(updateCarRequest.getModel());
        carToUpdate.setState(updateCarRequest.isState());
        carToUpdate.setPlate(updateCarRequest.getPlate());
        carToUpdate.setDailyPrice(updateCarRequest.getDailyPrice());
        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<GetByCarListResponse> getAllCars() {
        return carRepository.getAll();
    }

    @Override
    public List<GetByCarListResponse> findCarByDailyPriceBetween(Double min, Double max) {
        List<Car> cars = this.carRepository.findCarByDailyPriceBetween(min, max);
        List<GetByCarListResponse> carList = new ArrayList<>();
        for (Car car: cars) {
            GetByCarListResponse response = new GetByCarListResponse();
            response.setId(car.getId());
            response.setPlate(car.getPlate());
            response.setDailyPrice(car.getDailyPrice());
            //response.setModel(new GetModelListResponse(car.getModel().getName()));
            response.setModel(new GetByModelResponse(car.getModel().getName(), new GetBrandResponse(car.getModel().getBrand().getName())));
            carList.add(response);
        }
        return carList;
    }

    @Override
    public List<GetByCarListResponse> getByStateTrue() {
        List<Car> cars = carRepository.findByStateTrue();
        List<GetByCarListResponse> responses = new ArrayList<>();
        for (Car car: cars) {
            GetByCarListResponse response = new GetByCarListResponse();
            response.setId(car.getId());
            response.setPlate(car.getPlate());
            response.setDailyPrice(car.getDailyPrice());
            response.setState(car.isState());
            response.setModel(new GetByModelResponse(car.getModel().getName(), new GetBrandResponse(car.getModel().getBrand().getName())));
            //response.setModel(new GetModelListResponse(car.getModel().getName()));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetByCarListResponse> getByState(boolean state) {
        return carRepository.getCarByState(state);
    }

}
