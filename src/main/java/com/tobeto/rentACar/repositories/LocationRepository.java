package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    boolean existsByOfficePhone(String officePhone);
    boolean existsById(int id);

}
