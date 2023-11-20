package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {

    private final ModelRepository modelRepository;

    public ModelsController(ModelRepository modelRepository){
        this.modelRepository=modelRepository;
    }

    @GetMapping
    public List<Model> getAll(){
        return modelRepository.findAll();
    }


}
