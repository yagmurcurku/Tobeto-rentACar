package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public void add(AddBrandRequest request) {
        if (request.getName().length()<2){
            throw new RuntimeException("Marka adı 2 haneden kısa olamaz !");
        }
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<GetBrandListResponse>();
        for (Brand brand: brandList) {
            GetBrandListResponse brandResponse = new GetBrandListResponse();
            brandResponse.setId(brand.getId());
            brandResponse.setName(brand.getName());
            brandListResponses.add(brandResponse);
        }
        return brandListResponses;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

}
