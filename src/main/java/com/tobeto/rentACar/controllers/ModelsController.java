package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.ModelService;
import com.tobeto.rentACar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentACar.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentACar.services.dtos.responses.model.GetModelResponse;
import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {

    private final ModelService modelService;

    @GetMapping
    public List<GetModelListResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddModelRequest addModelRequest){
        modelService.add(addModelRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        modelService.update(updateModelRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }


    @GetMapping("/deneme2")
    public List<GetModelListResponse> getAllModels(@RequestParam double min, @RequestParam double max){
        return modelService.getAllModels(min, max);
    }


}
