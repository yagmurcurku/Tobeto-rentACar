package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //telefon numarası null olmayan user'lar
    List<User> findByPhoneIsNotNull();


    //telefon numarası null olan user'lar
    List<User> findByPhoneIsNull();


    //girilen id'ye ait arabayı bu zamana kadar kiralayan user'ların listesi
    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse(u.firstName," +
            "u.lastName, new com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse(c.plate)) FROM " +
            "Rental r INNER JOIN r.user u INNER JOIN r.car c WHERE r.car.id=:carId")
    List<GetByUserResponse> getUserByCar(int carId);


    //şuan kullanımda olan(state=true) arabaları kiralayan user'ların listesi
    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse(u.firstName," +
            "u.lastName, new com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse(c.plate))" +
            " FROM Rental r INNER JOIN r.car c INNER JOIN r.user u WHERE c.state=:state")
    List<GetByUserResponse> getUserByState(boolean state);


}
