package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentACar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserResponse;
import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping
    public List<GetUserListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow();
        GetUserResponse dto = new GetUserResponse();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setFirstName(addUserRequest.getFirstName());
        user.setLastName(addUserRequest.getLastName());
        user.setEmail(addUserRequest.getEmail());
        user.setPhone(addUserRequest.getPhone());
        userRepository.save(user);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
        User userToUpdate = userRepository.findById(updateUserRequest.getId()).orElseThrow();
        userToUpdate.setFirstName(updateUserRequest.getFirstName());
        userToUpdate.setLastName(updateUserRequest.getLastName());
        userToUpdate.setEmail(updateUserRequest.getEmail());
        userToUpdate.setPhone(updateUserRequest.getPhone());
        userRepository.save(userToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
