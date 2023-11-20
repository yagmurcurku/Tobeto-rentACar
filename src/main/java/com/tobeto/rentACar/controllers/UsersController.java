package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setRentals(user.getRentals());
        userRepository.save(userToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
