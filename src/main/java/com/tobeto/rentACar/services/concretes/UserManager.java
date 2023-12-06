package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.repositories.UserRepository;
import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentACar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<GetUserListResponse> getAll() {
        List<User> userList = userRepository.findAll();
        List<GetUserListResponse> userListResponses = new ArrayList<GetUserListResponse>();
        for (User user: userList) {
            GetUserListResponse userResponse = new GetUserListResponse();
            userResponse.setId(user.getId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setEmail(user.getEmail());
            userResponse.setPhone(user.getPhone());
            userListResponses.add(userResponse);
        }
        return userListResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetUserResponse dto = new GetUserResponse();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    @Override
    public void add(AddUserRequest addUserRequest) {
        User user = new User();
        user.setFirstName(addUserRequest.getFirstName());
        user.setLastName(addUserRequest.getLastName());
        user.setEmail(addUserRequest.getEmail());
        user.setPhone(addUserRequest.getPhone());
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User userToUpdate = userRepository.findById(updateUserRequest.getId()).orElseThrow();
        userToUpdate.setFirstName(updateUserRequest.getFirstName());
        userToUpdate.setLastName(updateUserRequest.getLastName());
        userToUpdate.setEmail(updateUserRequest.getEmail());
        userToUpdate.setPhone(updateUserRequest.getPhone());
        userRepository.save(userToUpdate);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<GetUserResponse> getByPhoneNotNull() {
        List<User> users = userRepository.findByPhoneIsNotNull();
        List<GetUserResponse> responses = new ArrayList<>();
        for (User user: users) {
            GetUserResponse response = new GetUserResponse();
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetUserResponse> getByPhoneNull() {
        List<User> users = userRepository.findByPhoneIsNull();
        List<GetUserResponse> responses = new ArrayList<>();
        for (User user: users) {
            GetUserResponse response = new GetUserResponse();
            response.setPhone(user.getPhone());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setEmail(user.getEmail());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetByUserResponse> getUserByCar(int carId) {
        return userRepository.getUserByCar(carId);
    }

    @Override
    public List<GetByUserResponse> getUserByState(boolean state) {
        return userRepository.getUserByState(state);
    }

}
