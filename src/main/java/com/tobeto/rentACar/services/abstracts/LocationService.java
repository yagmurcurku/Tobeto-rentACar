package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.location.AddLocationRequest;
import com.tobeto.rentACar.services.dtos.requests.location.UpdateLocationRequest;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationListResponse;
import com.tobeto.rentACar.services.dtos.responses.location.GetLocationResponse;

import java.util.List;

public interface LocationService {

    List<GetLocationListResponse> getAll();
    GetLocationResponse getById(int id);
    void add(AddLocationRequest addLocationRequest);
    void update(UpdateLocationRequest updateLocationRequest);
    void delete(int id);

}
