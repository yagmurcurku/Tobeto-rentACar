package com.tobeto.rentACar.services.dtos.responses.car;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.services.dtos.responses.model.GetByModelResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCarListResponse {

    private int id;
    private String plate;
    private double dailyPrice;
    private boolean state;
    //private String modelName;
    //private Model model;      //--> VERİTABANI TABLOSU DIŞA BU ŞEKİLDE AÇILMAMALI !
    private GetByModelResponse model;      //dto içinde dto kullanılabilir




}
