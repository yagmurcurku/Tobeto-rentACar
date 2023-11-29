package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
