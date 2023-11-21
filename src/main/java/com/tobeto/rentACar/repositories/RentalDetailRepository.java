package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.entities.RentalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDetailRepository extends JpaRepository<RentalDetail,Integer> {

}
