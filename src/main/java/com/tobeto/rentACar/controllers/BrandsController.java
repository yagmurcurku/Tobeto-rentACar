package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.BrandService;
import com.tobeto.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }


}
