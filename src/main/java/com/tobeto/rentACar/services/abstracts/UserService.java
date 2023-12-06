package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentACar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {

    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    void add(AddUserRequest addUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    List<GetUserResponse> getByPhoneNotNull();
    List<GetUserResponse> getByPhoneNull();
    List<GetByUserResponse> getUserByCar(int carId);
    List<GetByUserResponse> getUserByState(boolean state);

}
