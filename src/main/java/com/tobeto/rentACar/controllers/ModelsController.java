package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.model.AddModelRequest;
import com.tobeto.rentACar.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentACar.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentACar.dtos.responses.model.GetModelResponse;
import com.tobeto.rentACar.entities.Model;
import com.tobeto.rentACar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {

    private final ModelRepository modelRepository;

    public ModelsController(ModelRepository modelRepository){
        this.modelRepository=modelRepository;
    }

    @GetMapping
    public List<GetModelListResponse> getAll(){
        List<Model> modelList = modelRepository.findAll();
        List<GetModelListResponse> modelListResponses = new ArrayList<GetModelListResponse>();
        for (Model model: modelList) {
            GetModelListResponse modelResponse = new GetModelListResponse();
            modelResponse.setId(model.getId());
            modelResponse.setName(model.getName());
            modelResponse.setYear(model.getYear());
            modelResponse.setBrand(model.getBrand());
            modelListResponses.add(modelResponse);
        }
        return modelListResponses;
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id){

        Model model = modelRepository.findById(id).orElseThrow();
        GetModelResponse dto = new GetModelResponse();
        dto.setName(model.getName());
        dto.setYear(model.getYear());
        dto.setBrand(model.getBrand());
        return dto;

    }

    @PostMapping
    public void add(@RequestBody AddModelRequest addModelRequest){
        Model model = new Model();
        model.setName(addModelRequest.getName());
        model.setYear(addModelRequest.getYear());
        model.setBrand(addModelRequest.getBrand());
        modelRepository.save(model);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        Model modelToUpdate = modelRepository.findById(updateModelRequest.getId()).orElseThrow();
        modelToUpdate.setName(updateModelRequest.getName());
        modelToUpdate.setBrand(updateModelRequest.getBrand());
        modelToUpdate.setYear(updateModelRequest.getYear());
        //modelToUpdate.setCars(updateModelRequest.getCars());
        modelRepository.save(modelToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelRepository.deleteById(id);
    }


}
