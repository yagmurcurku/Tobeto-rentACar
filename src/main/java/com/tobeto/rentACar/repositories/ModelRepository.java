package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse(m.name, m.id, m.year," +
            "new com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse(b.name))" +
            " FROM Model m LEFT JOIN m.brand b WHERE m.year BETWEEN :min AND :max")
    List<GetModelListResponse> test(double min, double max);


}
/*
new com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse(m.name, m.id, " +
            "m.year, new com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse(b.name))" +
 */