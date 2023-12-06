package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentACar.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {

    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest addModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);

    List<GetModelListResponse> getAllModels(double min, double max);

}
