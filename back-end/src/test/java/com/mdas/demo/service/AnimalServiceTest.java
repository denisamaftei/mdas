package com.mdas.demo.service;

import com.mdas.demo.model.AnimalModel;
import com.mdas.demo.repository.AnimalRepository;
import com.mdas.demo.service.dto.AnimalDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalServiceTest {
    @Mock
    private AnimalRepository animalRepository;
    @InjectMocks
    private AnimalService animalService;

    @Test
    void getAllAnimals() {
        Mockito.when(animalRepository.findAll()).thenReturn((List<AnimalModel>) mockedAnimalList());
        assertThat(animalService.getAllPets()).hasSize(3);
    }

    @Test
    void getAllAnimalsToAdopt() {
        mockedAnimalList().forEach(x -> animalService.adoptAnimal(x));
        Mockito.when(animalRepository.findAllToAdopt()).thenReturn((List<AnimalModel>) mockedAnimalList());
        assertThat(animalService.getAllPetsToAdopt()).hasSize(3);
    }

    @Test
    void adoptAnimal() {
        AnimalModel animal = getMockedAnimal();
        animalService.adoptAnimal(animal);
        assertTrue(animal.getAdoptionStatus());
    }

    @Test
    void updateAnimal() {
        AnimalModel animalModel = getMockedAnimal();
        animalModel.setNume("Ralph");
        animalModel.setRasa("Amstaff");
        Mockito.when(animalRepository.save(animalModel)).thenReturn(animalModel);
        Assertions.assertEquals(animalService.updateAnimal(animalModel), new AnimalDTO(animalModel));
    }

    private Iterable<AnimalModel> mockedAnimalList() {
        return new ArrayList<>(Arrays.asList(getMockedAnimal(), getMockedAnimal(), getMockedAnimal()));
    }

    private AnimalModel getMockedAnimal() {
        return new AnimalModel(1L, "animal", "caine", "rasa", 3);
    }
}
