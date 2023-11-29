package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.rentACar.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentACar.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.rentACar.services.dtos.responses.rental.GetRentalResponse;

import java.util.List;

public interface RentalService {

    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    void add(AddRentalRequest addRentalRequest);
    void update(UpdateRentalRequest updateRentalRequest);
    void delete(int id);

}
