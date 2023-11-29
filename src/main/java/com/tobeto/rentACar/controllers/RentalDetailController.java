package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RentalDetailService;
import com.tobeto.rentACar.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import com.tobeto.rentACar.entities.RentalDetail;
import com.tobeto.rentACar.repositories.RentalDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentaldetails")
@AllArgsConstructor
public class RentalDetailController {

    private final RentalDetailService rentalDetailService;

    @GetMapping
    public List<GetRentalDetailListResponse> getAll(){
        return rentalDetailService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalDetailResponse getById(@PathVariable int id){
        return rentalDetailService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalDetailRequest addRentalDetailRequest){
        rentalDetailService.add(addRentalDetailRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalDetailRequest updateRentalDetailRequest){
        rentalDetailService.update(updateRentalDetailRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailService.delete(id);
    }

}
