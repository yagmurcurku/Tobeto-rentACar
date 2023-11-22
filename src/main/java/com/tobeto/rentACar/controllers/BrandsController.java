package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentACar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentACar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentACar.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandListResponses = new ArrayList<GetBrandListResponse>();
        for (Brand brand: brandList) {
            GetBrandListResponse brandListResponse = new GetBrandListResponse();
            brandListResponse.setId(brand.getId());
            brandListResponse.setName(brand.getName());
            brandListResponses.add(brandListResponse);
        }
        return brandListResponses;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        //Manuel mapping => Auto mapping
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){

        Brand brandToUpdate = brandRepository.findById(updateBrandRequest.getId()).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        //brandToUpdate.setModels(updateBrandRequest.getModels());
        brandRepository.save(brandToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        //Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        //kod buraya geliyorsa exception fırlamamıştır. if-else'e ihtiyaç duyulmaz
        //brandRepository.delete(brandToDelete);

        brandRepository.deleteById(id);
    }

}
