package com.mdas.demo.service;


import com.mdas.demo.model.AnimalModel;
import com.mdas.demo.repository.AnimalRepository;
import com.mdas.demo.service.dto.AnimalDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository){
        this.repository = repository;
    }

    public AnimalDTO addAnimal(AnimalModel model){
       AnimalModel savedModel = repository.save(model);
       return new AnimalDTO(savedModel);
    }

    public void deleteAnimal(Long id){
        repository.deleteById(id);
    }

    public AnimalDTO retrieveAnimal(Long id){
        Optional<AnimalModel> optAnimal = repository.findById(id);
        return optAnimal.isPresent() ? new AnimalDTO(optAnimal.get()) : null;
    }

    public List<AnimalDTO> retrieveAllAnimals(){

        Iterator<AnimalModel> iterator = repository.findAll().iterator();

        List<AnimalDTO> animalDTOS = new ArrayList<>();

        while(iterator.hasNext()){
            animalDTOS.add(new AnimalDTO(iterator.next()));
        }

       return animalDTOS;
    }

}
