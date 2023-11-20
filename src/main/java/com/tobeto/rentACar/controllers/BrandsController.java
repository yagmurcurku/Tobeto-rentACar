package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody Brand brand){

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        //Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        //kod buraya geliyorsa exception fırlamamıştır. if-else'e ihtiyaç duyulmaz
        //brandRepository.delete(brandToDelete);

        brandRepository.deleteById(id);
    }

}
