package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailResponse;

import java.util.List;

public interface RentalDetailService {

    List<GetRentalDetailListResponse> getAll();
    GetRentalDetailResponse getById(int id);
    void add(AddRentalDetailRequest addRentalDetailRequest);
    void update(UpdateRentalDetailRequest updateRentalDetailRequest);
    void delete(int id);

}
