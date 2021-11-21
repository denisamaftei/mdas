package com.mdas.demo.service;

import com.mdas.demo.model.AnimalModel;
import com.mdas.demo.repository.AnimalRepository;
import com.mdas.demo.service.dto.AnimalDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<AnimalModel> getAllPetsToAdopt() {
        List<AnimalModel> animalModelList = new ArrayList<>();
        animalRepository.findAllToAdopt().forEach(animalModelList::add);
        return animalModelList;
    }

    public List<AnimalModel> getAllPets() {
        List<AnimalModel> animalModelList = new ArrayList<>();
        animalRepository.findAll().forEach(animalModelList::add);
        return animalModelList;
    }

    void adoptAnimal(AnimalModel animalModel) {
        animalModel.setAdoptionStatus(true);
    }

    public AnimalDTO updateAnimal(AnimalModel animalModel) {
        animalRepository.save(animalModel);
        return new AnimalDTO(animalModel);
    }
}
