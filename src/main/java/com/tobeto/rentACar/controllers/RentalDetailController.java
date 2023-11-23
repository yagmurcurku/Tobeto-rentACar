package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.rentACar.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.rentACar.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.rentACar.dtos.responses.rentalDetail.GetRentalDetailResponse;
import com.tobeto.rentACar.entities.RentalDetail;
import com.tobeto.rentACar.repositories.RentalDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentaldetails")
public class RentalDetailController {

    private final RentalDetailRepository rentalDetailRepository;

    public RentalDetailController(RentalDetailRepository rentalDetailRepository){
        this.rentalDetailRepository=rentalDetailRepository;
    }

    @GetMapping
    public List<GetRentalDetailListResponse> getAll(){
        List<RentalDetail> rentalDetailList = rentalDetailRepository.findAll();
        List<GetRentalDetailListResponse> rentalDetailListResponses = new ArrayList<GetRentalDetailListResponse>();
        for (RentalDetail rentalDetail: rentalDetailList) {
            GetRentalDetailListResponse rentalDetailResponse = new GetRentalDetailListResponse();
            rentalDetailResponse.setId(rentalDetail.getId());
            rentalDetailResponse.setStartDate(rentalDetail.getStartDate());
            rentalDetailResponse.setEndDate(rentalDetail.getEndDate());
            rentalDetailResponse.setRental(rentalDetail.getRental());
            rentalDetailResponse.setLocationPickup(rentalDetail.getLocationPickup());
            rentalDetailResponse.setLocationDelivery(rentalDetail.getLocationDelivery());
            rentalDetailResponse.setEmployee(rentalDetail.getEmployee());
            rentalDetailListResponses.add(rentalDetailResponse);
        }
        return rentalDetailListResponses;
    }

    @GetMapping("{id}")
    public GetRentalDetailResponse getById(@PathVariable int id){
        RentalDetail rentalDetail = rentalDetailRepository.findById(id).orElseThrow();
        GetRentalDetailResponse dto = new GetRentalDetailResponse();
        dto.setStartDate(rentalDetail.getStartDate());
        dto.setEndDate(rentalDetail.getEndDate());
        dto.setRental(rentalDetail.getRental());
        dto.setLocationPickup(rentalDetail.getLocationPickup());
        dto.setLocationDelivery(rentalDetail.getLocationDelivery());
        dto.setEmployee(rentalDetail.getEmployee());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddRentalDetailRequest addRentalDetailRequest){
        RentalDetail rentalDetail = new RentalDetail();
        rentalDetail.setStartDate(addRentalDetailRequest.getStartDate());
        rentalDetail.setEndDate(addRentalDetailRequest.getEndDate());
        //rentalDetail.setRental(addRentalDetailRequest.getRental());
        rentalDetail.setLocationPickup(addRentalDetailRequest.getLocationPickup());
        rentalDetail.setLocationDelivery(addRentalDetailRequest.getLocationDelivery());
        rentalDetail.setEmployee(addRentalDetailRequest.getEmployee());
        rentalDetailRepository.save(rentalDetail);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalDetailRequest updateRentalDetailRequest){
        RentalDetail rentalDetailToUpdate = rentalDetailRepository.findById(updateRentalDetailRequest.getId()).orElseThrow();
        rentalDetailToUpdate.setStartDate(updateRentalDetailRequest.getStartDate());
        rentalDetailToUpdate.setEndDate(updateRentalDetailRequest.getEndDate());
        //rentalDetailToUpdate.setRental(updateRentalDetailRequest.getRental());
        rentalDetailToUpdate.setLocationPickup(updateRentalDetailRequest.getLocationPickup());
        rentalDetailToUpdate.setLocationDelivery(updateRentalDetailRequest.getLocationDelivery());
        rentalDetailToUpdate.setEmployee(updateRentalDetailRequest.getEmployee());
        rentalDetailRepository.save(rentalDetailToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalDetailRepository.deleteById(id);
    }

}
