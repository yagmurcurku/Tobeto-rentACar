package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.UserService;
import com.tobeto.rentACar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentACar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetUserResponse;
import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping
    public List<GetUserListResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddUserRequest addUserRequest){
        userService.add(addUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }


    @GetMapping("/getByPhoneNotNull")
    public List<GetUserResponse> getByPhoneNotNull(){
        return userService.getByPhoneNotNull();
    }

    @GetMapping("/getByPhoneNull")
    public List<GetUserResponse> getByPhoneNull(){
        return userService.getByPhoneNull();
    }

    @GetMapping("/getUserByCar")
    public List<GetByUserResponse> getUser(@RequestParam int carId){
        return userService.getUserByCar(carId);
    }


    @GetMapping("/getUserByState")
    public List<GetByUserResponse> getUserByState(@RequestParam boolean state){
        return userService.getUserByState(state);
    }


}
