package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public Model getById(@PathVariable int id){
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Model model){
        modelRepository.save(model);
    }

    @PutMapping
    public void update(@RequestBody Model model){
        Model modelToUpdate = modelRepository.findById(model.getId()).orElseThrow();
        modelToUpdate.setName(model.getName());
        modelToUpdate.setBrand(model.getBrand());
        modelToUpdate.setYear(model.getYear());
        modelToUpdate.setCars(model.getCars());
        modelRepository.save(modelToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelRepository.deleteById(id);
    }


}
