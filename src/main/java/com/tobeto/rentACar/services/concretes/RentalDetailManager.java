package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.RentalDetail;
import com.tobeto.rentACar.repositories.RentalDetailRepository;
import com.tobeto.rentACar.services.abstracts.RentalDetailService;
import com.tobeto.rentACar.services.dtos.requests.rentalDetail.AddRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.requests.rentalDetail.UpdateRentalDetailRequest;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailListResponse;
import com.tobeto.rentACar.services.dtos.responses.rentalDetail.GetRentalDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalDetailManager implements RentalDetailService {

    private final RentalDetailRepository rentalDetailRepository;

    @Override
    public List<GetRentalDetailListResponse> getAll() {
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

    @Override
    public GetRentalDetailResponse getById(int id) {
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

    @Override
    public void add(AddRentalDetailRequest addRentalDetailRequest) {
        RentalDetail rentalDetail = new RentalDetail();
        rentalDetail.setStartDate(addRentalDetailRequest.getStartDate());
        rentalDetail.setEndDate(addRentalDetailRequest.getEndDate());
        //rentalDetail.setRental(addRentalDetailRequest.getRental());
        rentalDetail.setLocationPickup(addRentalDetailRequest.getLocationPickup());
        rentalDetail.setLocationDelivery(addRentalDetailRequest.getLocationDelivery());
        rentalDetail.setEmployee(addRentalDetailRequest.getEmployee());
        rentalDetailRepository.save(rentalDetail);
    }

    @Override
    public void update(UpdateRentalDetailRequest updateRentalDetailRequest) {
        RentalDetail rentalDetailToUpdate = rentalDetailRepository.findById(updateRentalDetailRequest.getId()).orElseThrow();
        rentalDetailToUpdate.setStartDate(updateRentalDetailRequest.getStartDate());
        rentalDetailToUpdate.setEndDate(updateRentalDetailRequest.getEndDate());
        //rentalDetailToUpdate.setRental(updateRentalDetailRequest.getRental());
        rentalDetailToUpdate.setLocationPickup(updateRentalDetailRequest.getLocationPickup());
        rentalDetailToUpdate.setLocationDelivery(updateRentalDetailRequest.getLocationDelivery());
        rentalDetailToUpdate.setEmployee(updateRentalDetailRequest.getEmployee());
        rentalDetailRepository.save(rentalDetailToUpdate);
    }

    @Override
    public void delete(int id) {
        rentalDetailRepository.deleteById(id);
    }

}
