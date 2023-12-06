package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {


    //zaten entities.car'daki @JoinColumn ile join geldiğinde join kolonu olarak hangi kolonu
    //kullanacağı programa bildirildi. Bu yüzden sql'deki gibi uzun uzun join yapmaya gerek yok
        //yani şöyle --> "Select * from Cars c Inner Join models m ON c.model_id=m.id" bu gerekmez.

    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.car.GetByCarListResponse(c.id, c.plate, c.dailyPrice, " +
            "c.state, new com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse(m.name, m.id, m.year, " +
            "new com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse(b.name))) FROM Car c " +
            "INNER JOIN c.model m INNER JOIN m.brand b")
    List<GetByCarListResponse> getAll();
            //constructor sırası sınıftaki haliyle aynı olmalı ! (plate, dailyPrice,...)

    List<Car> findCarByDailyPriceBetween(Double min, Double max);

}
//new com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse(m.name)